package dojo.himnabil.dare2quiz.controller;

import dojo.himnabil.dare2quiz.model.Question;
import dojo.himnabil.dare2quiz.service.QuestionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
   private final QuestionService questionService ;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/players/{player-id}/ask")
    public void askQuestion(@PathVariable("player-id") String askedId, @RequestBody Question question) {
        questionService.askQuestion(askedId, question);
    }
}
