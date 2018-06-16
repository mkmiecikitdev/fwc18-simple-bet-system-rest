package eu.bambz.fwc18simplebetsystem

import spock.lang.Specification

class BetSystemAcceptanceSpecs extends Specification{

    def "scenarios" () {

        when: 'I get /matches'
        then: 'I see all matches'

        when: 'I get /points'
        then: 'I see current points for me and second player'

        when: 'I put /match/{id} when can updating this match'
        then: 'I get updated match and 200'

        when: 'I put /match/{id} when cannot updating'
        then: 'I get 4xx'

    }


}
