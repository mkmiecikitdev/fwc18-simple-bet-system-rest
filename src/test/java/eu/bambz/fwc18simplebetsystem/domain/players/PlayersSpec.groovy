package eu.bambz.fwc18simplebetsystem.domain.players

import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersQueryConfig
import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersQueryFacade
import spock.lang.Specification

class PlayersSpec extends Specification {

    PlayersQueryFacade playersFacade

    def setup() {

        playersFacade = new PlayersQueryConfig().playersQueryFacade()

    }

    def " players() should return both players with calculated all points" () {

        given: "Persisted and bet some matches"

        when: "User want to see players with their scores"

            def result = playersFacade.playersSummary()

        then: "User get Michal with 4 points and Tomek with 1"

            result.player1Name == "Michal"
            result.player1Score == 4
            result.player2Name == "Tomek"
            result.player2Score == 1
    }

}
