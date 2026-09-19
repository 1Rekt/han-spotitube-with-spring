package nl.han.aim.oose.dea.spotitubewithspring.datasource.repositories;

import nl.han.aim.oose.dea.spotitubewithspring.datasource.entities.Playlist;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, String> {

}
