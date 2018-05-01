package dojo.himnabil.dare2quiz.model;

import lombok.*;

import java.util.ArrayDeque;
import java.util.Queue;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Player {

    public static final Integer DEFAULT_COINS_VALUE = 100;

    @Getter
    final private String id ;

    @Getter
    @Setter
    private int nbCoins = DEFAULT_COINS_VALUE;

    @Getter
    final private Queue<Question> questions = new ArrayDeque<>();

}
