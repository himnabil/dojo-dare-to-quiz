package dojo.himnabil.dare2quiz.controller;

import dojo.himnabil.dare2quiz.model.Question;
import dojo.himnabil.dare2quiz.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class QuestionController {
    public static final String PLAYER_ID = "player-id";
    public static final String PLAYERS_PLAYER_ID_ASK = "/players/{" + PLAYER_ID + "}/ask";
    public static final String PLAYERS_PLAYER_ID = "/players/{" + PLAYER_ID + "}";
    public static final String PLAYERS_PLAYER_ID_ANSWER = "/players/{" + PLAYER_ID + "}/answer";
    private final QuestionService questionService ;


    @PostMapping(PLAYERS_PLAYER_ID_ASK)
    public void askQuestion(@PathVariable(PLAYER_ID) String askedId, @RequestBody Question question) {
        questionService.askQuestion(askedId, question);
    }

    @PostMapping(PLAYERS_PLAYER_ID_ANSWER)
    public void anwserQuestion(@PathVariable(PLAYER_ID) String askedId, @RequestBody String answer) {
        questionService.answerQuestion(askedId, answer);
    }

    @GetMapping(PLAYERS_PLAYER_ID)
    public Question getCurrentQuestion(@PathVariable(PLAYER_ID) String askedId) {
        return questionService.getCurrentQuestion(askedId);
    }
}
