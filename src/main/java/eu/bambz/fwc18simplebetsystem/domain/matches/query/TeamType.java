package eu.bambz.fwc18simplebetsystem.domain.matches.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
enum TeamType {

    RUS("Rosja"),
    ARA("Arabia"),
    EGI("Egipt"),
    URU("Urugwaj");

    private String label;

}
