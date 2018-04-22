package dojo.himnabil.dare2quiz.controller;

import dojo.himnabil.dare2quiz.model.Question;
import dojo.himnabil.dare2quiz.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class QuestionController {
    public static final String PLAYER_ID = "player-id";
    public static final String PLAYERS_PLAYER_ID_ASK = "/players/{" + PLAYER_ID + "}/ask";
    private final QuestionService questionService ;


    @PostMapping(PLAYERS_PLAYER_ID_ASK)
    public void askQuestion(@PathVariable(PLAYER_ID) String askedId, @RequestBody Question question) {
        questionService.askQuestion(askedId, question);
    }
}
