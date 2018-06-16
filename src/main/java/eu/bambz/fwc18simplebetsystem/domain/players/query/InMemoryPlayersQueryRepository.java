package eu.bambz.fwc18simplebetsystem.domain.players.query;

public class InMemoryPlayersQueryRepository implements PlayersQueryRepository {


    @Override
    public int player1Score() {
        return 4;
    }


    @Override
    public int player2Score() {
        return 1;
    }


}
