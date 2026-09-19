package nl.han.aim.oose.dea.spotitubewithspring.datasource.repositories;

import nl.han.aim.oose.dea.spotitubewithspring.datasource.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByToken(String token);

}
