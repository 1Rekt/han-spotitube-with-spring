package nl.han.aim.oose.dea.spotitubewithspring.services.implementations;

import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.PlaylistDTO;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.DTOs.PlaylistsDTO;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.entities.User;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.mappers.PlaylistMapper;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.repositories.PlaylistRepository;
import nl.han.aim.oose.dea.spotitubewithspring.datasource.repositories.UserRepository;
import nl.han.aim.oose.dea.spotitubewithspring.services.PlaylistService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    PlaylistRepository playlistRepository;
    UserRepository userRepository;
    PlaylistMapper playlistMapper;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository, UserRepository userRepository, PlaylistMapper playlistMapper) {
        this.playlistRepository = playlistRepository;
        this.userRepository = userRepository;
        this.playlistMapper = playlistMapper;
    }

    @Override
    public PlaylistsDTO getAllPlaylists(String token) {
        User user = userRepository.findByToken(token).get(0);
        PlaylistsDTO playlistsDTO = new PlaylistsDTO();
        ArrayList<PlaylistDTO> playlists = new ArrayList<>();
        playlistRepository.findAll().forEach(playlist -> {
            playlists.add(playlistMapper.mapPlaylist(playlist, user.getUsername()));
        });
        playlistsDTO.setPlaylists(playlists);

        return playlistsDTO;
    }

}
