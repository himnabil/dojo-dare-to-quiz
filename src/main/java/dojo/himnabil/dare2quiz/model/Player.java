package dojo.himnabil.dare2quiz.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash("player")
public class Player implements Serializable {

    public static final BigDecimal DEFAULT_COINS_VALUE = new BigDecimal(100);

    @Getter
    @Setter
    private String id ;

    @Getter
    @Setter
    private BigDecimal nbCoins = DEFAULT_COINS_VALUE;

    @Getter
    final private LinkedList<Question> questions = new LinkedList<>();

    public Player(String playerId) {
        this.id = playerId;
    }
}
