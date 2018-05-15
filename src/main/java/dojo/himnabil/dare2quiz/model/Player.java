package dojo.himnabil.dare2quiz.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Queue;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Player {

    public static final BigDecimal DEFAULT_COINS_VALUE = new BigDecimal(100);

    @Getter
    final private String id ;

    @Getter
    @Setter
    private BigDecimal nbCoins = DEFAULT_COINS_VALUE;

    @Getter
    final private Queue<Question> questions = new ArrayDeque<>();

}
