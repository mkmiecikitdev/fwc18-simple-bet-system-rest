package eu.bambz.fwc18simplebetsystem.infrastructure.rest.controllers;

import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersQueryFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
class UsersController {

    private final PlayersQueryFacade playersQueryFacade;

    @PostMapping(value = "/login")
    PlayerType loginUser() {
        return playersQueryFacade.currentPlayer();
    }

}
