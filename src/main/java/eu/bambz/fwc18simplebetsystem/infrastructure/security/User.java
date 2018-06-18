package eu.bambz.fwc18simplebetsystem.infrastructure.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

import static java.util.Collections.emptyList;

@Table(name = "players")
@Entity
@Getter
public class User implements UserDetails {

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "player_type")
    private PlayerType playerType;

    @Column(nullable = false)
    private String password;

    @JsonIgnore
    @Override
    public String getUsername() {
        return playerType.getLabel();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return emptyList();
    }

}

