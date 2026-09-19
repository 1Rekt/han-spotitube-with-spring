package nl.han.aim.oose.dea.spotitubewithspring.datasource.mappers;

import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.PlaylistDTO;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.entities.Playlist;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class PlaylistMapper {

    public PlaylistDTO mapPlaylist(Playlist playlist, String username) {
        PlaylistDTO playlistDTO = new PlaylistDTO();
        playlistDTO.setId(playlist.getId());
        playlistDTO.setName(playlist.getName());
        playlistDTO.setOwner(playlist.getOwner().equals(username));
        playlistDTO.setTracks(new ArrayList<>());
        return playlistDTO;
    }

}
