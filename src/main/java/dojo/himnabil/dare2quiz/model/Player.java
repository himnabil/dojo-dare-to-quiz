package dojo.himnabil.dare2quiz.model;

import lombok.*;

import java.util.ArrayDeque;
import java.util.Queue;

@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Player {

    public static final Integer DEFAULT_COINS_VALUE = 100;

    @Getter
    private String id ;

    @Getter
    @Setter
    private int nbCoins = DEFAULT_COINS_VALUE;

    @Getter
    private Queue<Question> questions = new ArrayDeque<>();

}
