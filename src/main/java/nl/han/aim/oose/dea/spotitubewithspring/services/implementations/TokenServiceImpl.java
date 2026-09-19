package nl.han.aim.oose.dea.spotitubewithspring.services.implementations;

import nl.han.aim.oose.dea.spotitubewithspring.datasource.repositories.UserRepository;
import nl.han.aim.oose.dea.spotitubewithspring.services.TokenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {
    UserRepository userRepository;

    public TokenServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String generateToken() {
        String token = UUID.randomUUID().toString();
        while (!userRepository.findByToken(token).isEmpty()) {
            token = UUID.randomUUID().toString();
        }
        return token;
    }
}
