package eu.bambz.fwc18simplebetsystem.domain.players

import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersQueryConfig
import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersQueryFacade
import spock.lang.Specification

class PlayersSpec extends Specification {

    PlayersQueryFacade playersFacade

    def setup() {

        playersFacade = new PlayersQueryConfig().playersQueryFacade()

    }

}
