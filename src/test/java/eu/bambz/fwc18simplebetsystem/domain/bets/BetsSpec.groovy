package eu.bambz.fwc18simplebetsystem.domain.bets

import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetForm
import eu.bambz.fwc18simplebetsystem.domain.bets.query.BetsQueryConfig
import eu.bambz.fwc18simplebetsystem.domain.bets.query.BetsQueryFacade
import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType
import eu.bambz.fwc18simplebetsystem.domain.players.query.PlayersQueryFacade
import spock.lang.Specification

import java.time.LocalDateTime

class BetsSpec extends Specification {

    BetsQueryFacade betsQueryFacade
    BetsFacade betsFacade


    def setup() {

        betsQueryFacade = new BetsQueryConfig().betsQueryFacade()

        PlayersQueryFacade playersFacade = Mock()
        playersFacade.currentPlayer() >> PlayerType.M

        betsFacade = new BetsConfig().betsFacade(playersFacade)

    }

    def " bets() should return matches with real info about teams, date, result, score for users and flag that is it possible to betting yet" () {

        given: "There is saved list of past and upcoming matches and now is 15.06.2018 13:45"

        when: "User want to see this matches"

            def list = betsQueryFacade.list()
            def firstBet = list.get(0)
            def secondBet = list.get(1)

        then: "User see all persisted matches"

            list != null
            list.size() == 2

            firstBet.id == 1L

            firstBet.team1.name == "Rosja"
            firstBet.team1.score == 5

            firstBet.team2.name == "Arabia"
            firstBet.team2.score == 0

            firstBet.player1.name == "Michal"
            firstBet.player1.team1Bet == 5
            firstBet.player1.team2Bet == 0
            firstBet.player1.score == 3

            firstBet.player2.name == "Tomek"
            firstBet.player2.team1Bet == 2
            firstBet.player2.team2Bet == 1
            firstBet.player2.score == 1

            firstBet.time == LocalDateTime.of(2018, 6, 14, 18, 0)
            !firstBet.canBet

            secondBet.id == 2L

            secondBet.team1.name == "Egipt"
            secondBet.team1.score == null

            secondBet.team2.name == "Urugwaj"
            secondBet.team2.score == null

            secondBet.player1.name == "Michal"
            secondBet.player1.team1Bet == 2
            secondBet.player1.team2Bet == 0
            secondBet.player1.score == null

            secondBet.player2.name == "Tomek"
            secondBet.player2.team1Bet == 0
            secondBet.player2.team2Bet == 1
            secondBet.player2.score == null

            secondBet.time == LocalDateTime.of(2018, 6, 15, 14, 0)
            secondBet.canBet


    }


    def " bet(id, betForm) should change player bets and return bet if can betting" () {

        given: "There is saved list of past and upcoming matches and now is 15.06.2018 13:45"

        when: "User want to change bet of id 2L"

            def id = 2L
            def form = new BetForm(4, 4)

            def longOpt = betsFacade.bet(id, form)
            def bet = betsQueryFacade.find(longOpt.get())

        then: "Bet is changed and returned"

            !longOpt.isEmpty()
            longOpt.get() == 2L

            bet.id == 2L

            bet.team1.name == "Egipt"
            bet.team1.score == null

            bet.team2.name == "Urugwaj"
            bet.team2.score == null

            bet.player1.name == "Michal"
            bet.player1.team1Bet == 4
            bet.player1.team2Bet == 4
            bet.player1.score == null

            bet.player2.name == "Tomek"
            bet.player2.team1Bet == 0
            bet.player2.team2Bet == 1
            bet.player2.score == null

            bet.time == LocalDateTime.of(2018, 6, 15, 14, 0)
            bet.canBet

    }


}
