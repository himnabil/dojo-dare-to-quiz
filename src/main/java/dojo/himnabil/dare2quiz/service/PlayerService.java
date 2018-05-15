package dojo.himnabil.dare2quiz.service;

import dojo.himnabil.dare2quiz.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PlayerService {


    private PlayerRepository playerRepository;

    public BigDecimal getCoins(String askedId) {
       return playerRepository.getPlayer(askedId).getNbCoins();
    }
}
