package eu.bambz.fwc18simplebetsystem.domain.matches.query

import spock.lang.Specification

import java.time.LocalDateTime

class MatchesSpec extends Specification {

    MatchesQueryFacade matchesQueryFacade

    def setup() {

        matchesQueryFacade = new MatchesQueryConfig().matchesQueryFacade()

    }

    def " 'matches()' should return matches with real info about teams, date, result, score for users and flag that is it possible to betting yet" () {

        given: "There is saved list of past and upcoming matches and now is 15.06.2018 13:45"

        when: "User want to see this matches"

            def list = matchesQueryFacade.list()
            def firstMatch = list.get(0)
            def secondMatch = list.get(1)

        then: "User see all persisted matches"

            list != null
            list.size() == 2

            firstMatch.id == 1L
            firstMatch.team1.name == "Rosja"
            firstMatch.team1.score == 5
            firstMatch.team2.name == "Arabia"
            firstMatch.team2.score == 0
            firstMatch.time == LocalDateTime.of(2018, 6, 14, 18, 0);
            !firstMatch.canBet

            secondMatch.id == 2L
            secondMatch.team1.name == "Egipt"
            secondMatch.team1.score == null
            secondMatch.team2.name == "Urugwaj"
            secondMatch.team2.score == null
            secondMatch.time == LocalDateTime.of(2018, 6, 15, 14, 0);
            secondMatch.canBet


    }


}
