package eu.bambz.fwc18simplebetsystem.domain.matches.query;

import eu.bambz.fwc18simplebetsystem.domain.matches.api.TeamDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
class TeamMatchSection {

    private TeamType teamType;
    private Integer score;

    TeamDto dto() {
        return new TeamDto(teamType.getLabel(), score);
    }

}
