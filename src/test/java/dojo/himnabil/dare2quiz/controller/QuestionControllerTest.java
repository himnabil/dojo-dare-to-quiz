package dojo.himnabil.dare2quiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dojo.himnabil.dare2quiz.model.Player;
import dojo.himnabil.dare2quiz.model.Question;
import dojo.himnabil.dare2quiz.service.QuestionService;
import org.assertj.core.util.Sets;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@WebFluxTest(QuestionController.class)
public class QuestionControllerTest {


    @Autowired
    private WebTestClient webTestClient;

    private static final String POST_ASK_QUESTION = QuestionController.PLAYERS_PLAYER_ID_ASK;

    @MockBean
    private QuestionService service;

    private QuestionController controller;

    @Before
    public void setup() {
        controller = new QuestionController(service);
    }

    @Test
    public void askQuestion() throws Exception {
        Question question = Question.builder()
                .nbCoins(BigDecimal.TEN)
                .owner(Player
                        .builder()
                        .nbCoins(BigDecimal.TEN)
                        .id("1")
                        .build())
                .value("toto?")
                .validAnswer("validAnswer")
                .answers(Sets.newLinkedHashSet("validAnswer", "badAnswer1"))
                .build();
        webTestClient.post().uri(POST_ASK_QUESTION, "1")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(new ObjectMapper().writeValueAsString(question)))
                .exchange().expectStatus().isOk();
    }
}