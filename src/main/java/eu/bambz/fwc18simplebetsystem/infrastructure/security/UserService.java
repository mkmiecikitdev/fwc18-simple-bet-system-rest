package eu.bambz.fwc18simplebetsystem.infrastructure.security;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import eu.bambz.fwc18simplebetsystem.domain.players.query.CurrentPlayerLoader;
import io.vavr.collection.Array;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class UserService implements UserDetailsService, CurrentPlayerLoader {

    private final UsersRepository usersRepository;

    @Override
    public PlayerType load() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (PlayerType) auth.getPrincipal();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PlayerType playerType = Array.of(PlayerType.values())
                .find(pType -> pType.getLabel().equalsIgnoreCase(s))
                .getOrElseThrow(() -> new UsernameNotFoundException("Not found user with login " + s));

        return usersRepository.findById(playerType)
                .orElseThrow(() -> new UsernameNotFoundException("Not found user with login " + s));

    }

}
