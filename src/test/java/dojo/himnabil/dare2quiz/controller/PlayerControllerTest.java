package dojo.himnabil.dare2quiz.controller;

import dojo.himnabil.dare2quiz.service.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static dojo.himnabil.dare2quiz.controller.PlayerController.PLAYER_COINS_API;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class PlayerControllerTest {



    private MockMvc mockMvc;

    @Mock
    private PlayerService service;

    @InjectMocks
    private PlayerController controller;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getCoin() throws Exception {
        when(service.getCoins("1")).thenReturn(BigDecimal.TEN);
        this.mockMvc
                .perform(get(PLAYER_COINS_API, "1"))
                .andExpect(status().isOk())

        .andExpect(MockMvcResultMatchers.content().string("10"));
    }
}