package nl.han.aim.oose.dea.spotitubewithspring.controllers;

import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.LoginRequestDTO;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.UserDTO;
import nl.han.aim.oose.dea.spotitubewithspring.services.LoginService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/login")
public class LoginController {
    LoginService loginService;

    LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> loginRequest(@RequestBody LoginRequestDTO loginCredentials) {
        loginService.loginCredentialsCorrect(loginCredentials);
        return ResponseEntity.ok(loginService.generateLoginResponse(loginCredentials.getUser()));
    }

}
