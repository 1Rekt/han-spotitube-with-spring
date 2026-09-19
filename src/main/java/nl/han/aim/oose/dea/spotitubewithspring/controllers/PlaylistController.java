package nl.han.aim.oose.dea.spotitubewithspring.controllers;

import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.PlaylistsDTO;
import nl.han.aim.oose.dea.spotitubewithspring.services.AuthenticationService;
import nl.han.aim.oose.dea.spotitubewithspring.services.PlaylistService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/playlists")
public class PlaylistController {
    PlaylistService playlistService;
    AuthenticationService authenticationService;

    PlaylistController(PlaylistService playlistService, AuthenticationService authenticationService) {
        this.playlistService = playlistService;
        this.authenticationService = authenticationService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaylistsDTO> getAllPlaylists(@RequestParam("token") String token) {
        authenticationService.verifyTokenExists(token);
        return ResponseEntity.ok(playlistService.getAllPlaylists(token));
    }

}
