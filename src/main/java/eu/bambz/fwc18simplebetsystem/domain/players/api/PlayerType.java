package eu.bambz.fwc18simplebetsystem.domain.players.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PlayerType {

    M("Michal"),
    T("Tomek");

    private final String label;

}
