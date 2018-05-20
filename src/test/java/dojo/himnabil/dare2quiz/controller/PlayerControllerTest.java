package dojo.himnabil.dare2quiz.controller;

import dojo.himnabil.dare2quiz.service.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static dojo.himnabil.dare2quiz.controller.PlayerController.PLAYER_COINS_API;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(PlayerController.class)
public class PlayerControllerTest {


    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private PlayerService service;


    @Test
    public void getCoin() throws Exception {
        when(service.getCoins("1")).thenReturn(BigDecimal.TEN);

        this.webTestClient
                .get().
                uri(PLAYER_COINS_API, "1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class).isEqualTo(BigDecimal.TEN);

    }
}