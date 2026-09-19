package nl.han.aim.oose.dea.spotitubewithspring.services.implementations;

import nl.han.aim.oose.dea.spotitubewithspring.datasource.repositories.UserRepository;
import nl.han.aim.oose.dea.spotitubewithspring.services.AuthenticationService;
import nl.han.aim.oose.dea.spotitubewithspring.services.exceptions.TokenDoesntExistException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void verifyTokenExists(String token) {
        if (userRepository.findByToken(token).isEmpty()) {
            throw new TokenDoesntExistException();
        }
    }

}
