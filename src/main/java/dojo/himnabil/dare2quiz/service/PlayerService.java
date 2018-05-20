package dojo.himnabil.dare2quiz.service;

import dojo.himnabil.dare2quiz.model.Player;
import dojo.himnabil.dare2quiz.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class PlayerService {


    private PlayerRepository playerRepository;


    public BigDecimal getCoins(String askedId) {
       return getOrCreate(askedId).getNbCoins();
    }

    public Player getOrCreate(String playerId) {
        return playerRepository.findById(playerId)
                .orElse(create(playerId));
    }

    public Player create(String playerId) {
        return playerRepository.save(new Player(playerId));
    }


}
