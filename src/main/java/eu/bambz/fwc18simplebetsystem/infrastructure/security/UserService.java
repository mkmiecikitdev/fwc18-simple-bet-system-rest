package eu.bambz.fwc18simplebetsystem.infrastructure.security;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import io.vavr.collection.Array;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PlayerType playerType = Array.of(PlayerType.values())
                .find(pType -> pType.getLabel().equalsIgnoreCase(s))
                .getOrElseThrow(() -> new UsernameNotFoundException("Not found user with login " + s));

        return usersRepository.findById(playerType)
                .orElseThrow(() -> new UsernameNotFoundException("Not found user with login " + s));

    }

}
