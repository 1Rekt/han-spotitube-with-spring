package nl.han.aim.oose.dea.spotitubewithspring.services;

import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.PlaylistsDTO;

public interface PlaylistService {
    PlaylistsDTO getAllPlaylists(String token);
}
