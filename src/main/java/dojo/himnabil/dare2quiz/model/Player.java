package dojo.himnabil.dare2quiz.model;

import lombok.Getter;
import lombok.Setter;


public class Player {
    public Player(String id, int nbCoins) {
        this.id = id;
        this.nbCoins = nbCoins;
    }

    @Getter
    private String id ;

    @Getter
    @Setter
    private int nbCoins;

}
