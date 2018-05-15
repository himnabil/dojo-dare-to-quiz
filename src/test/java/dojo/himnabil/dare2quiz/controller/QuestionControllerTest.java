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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTest {


    private MockMvc mockMvc;

    private static final String POST_ASK_QUESTION = QuestionController.PLAYERS_PLAYER_ID_ASK;

    @Mock
    private QuestionService service;

    private QuestionController controller;

    @Before
    public void setup() {

        controller = new QuestionController(service);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
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
        this.mockMvc
                .perform(post(POST_ASK_QUESTION, "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(question)))
                .andExpect(status().isOk());
    }
}