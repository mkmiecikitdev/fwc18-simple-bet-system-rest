package eu.bambz.fwc18simplebetsystem.domain.bets.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
enum TeamType {

    RUS("Rosja"),
    ARA("Arabia"),
    EGI("Egipt"),
    URU("Urugwaj"),

    HISZ("Hiszpania"),
    POR("Portugalia"),
    IRA("Iran"),
    MAR("Maroko"),

    DAN("Dania"),
    AUS("Australia"),
    FRA("Francja"),
    PER("Peru"),

    NIG("Nigeria"),
    ARG("Argentyna"),
    ISL("Islandia"),
    CHO("Chorwacja"),

    SZW("Szwajcaria"),
    BRA("Brazylia"),
    KOS("Kostaryka"),
    SER("Serbia"),

    MEK("Meksyk"),
    KOR("Korea"),
    NIE("Niemcy"),
    SWE("Szwecja"),

    TUN("Tunezja"),
    ANG("Anglia"),
    PAN("Panama"),
    BEL("Belgia"),

    POL("Polska"),
    JAP("Japonia"),
    SEN("Senegal"),
    KOL("Kolumbia");

    private String label;

}
