package nl.han.aim.oose.dea.spotitubewithspring.services;


import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.LoginRequestDTO;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.UserDTO;

public interface LoginService {
    void loginCredentialsCorrect(LoginRequestDTO loginCredentials);

    UserDTO generateLoginResponse(String username);
}
