package dojo.himnabil.dare2quiz.repository;

import dojo.himnabil.dare2quiz.model.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class PlayerRepository {
    private Map<String, Player> playersById = new HashMap<>();


    public Player getPlayer(String askedPlayerId) {
        if (playersById.containsKey(askedPlayerId)) {
            return playersById.get(askedPlayerId);
        } else {
            Player player= Player.builder().id(askedPlayerId).build();
            playersById.put(askedPlayerId, player);
            log.info("new player with id {} created", askedPlayerId);
            return player;
        }
    }
}
