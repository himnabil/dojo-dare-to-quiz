package dojo.himnabil.dare2quiz.controller;

import dojo.himnabil.dare2quiz.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class PlayerController {

    public static final String PLAYER_COINS_API = "/player/{askedId}/coins";
    private PlayerService playerService;

    @GetMapping(PLAYER_COINS_API)
    public BigDecimal getCoins(@PathVariable() String askedId) {
        return playerService.getCoins(askedId);
    }

}
