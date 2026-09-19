package nl.han.aim.oose.dea.spotitubewithspring.services.implementations;

import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.LoginRequestDTO;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.UserDTO;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.entities.User;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.repositories.UserRepository;
import nl.han.aim.oose.dea.spotitubewithspring.services.LoginService;
import nl.han.aim.oose.dea.spotitubewithspring.services.TokenService;
import nl.han.aim.oose.dea.spotitubewithspring.services.exceptions.LoginCredentialsIncorrectException;
import nl.han.aim.oose.dea.spotitubewithspring.services.util.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    TokenService tokenService;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    LoginServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public void loginCredentialsCorrect(LoginRequestDTO loginCredentials) {
        User user = userRepository.findById(loginCredentials.getUser()).orElse(null);
        if (user == null || !passwordEncoder.checkPassword(loginCredentials.getPassword(), user.getPassword())) {
            throw new LoginCredentialsIncorrectException();
        }
    }

    @Override
    public UserDTO generateLoginResponse(String username) {
        User user = userRepository.findById(username).orElse(null);
        String token = tokenService.generateToken();
        user.setToken(token);
        userRepository.save(user);
        UserDTO loginResponse = new UserDTO();
        loginResponse.setUser(user.getFull_name());
        loginResponse.setToken(user.getToken());
        return loginResponse;
    }
}
