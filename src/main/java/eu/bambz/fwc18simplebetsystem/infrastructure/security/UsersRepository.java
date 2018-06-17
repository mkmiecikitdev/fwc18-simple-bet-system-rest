package eu.bambz.fwc18simplebetsystem.infrastructure.security;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, PlayerType> {

}
