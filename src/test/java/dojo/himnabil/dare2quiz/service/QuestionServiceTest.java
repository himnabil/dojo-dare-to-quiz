package dojo.himnabil.dare2quiz.service;

import dojo.himnabil.dare2quiz.model.Player;
import dojo.himnabil.dare2quiz.model.Question;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class QuestionServiceTest {
    private QuestionService questionService = new QuestionService();
    private Player player = new Player("1", 1);
    private Player player2 = new Player("2", 1);

    @Test
    public void askQuestion() {
        Set<String> answers = new HashSet<>();
        answers.add("dgfqs");
        answers.add("toto");

        questionService.askQuestion("2", new Question(1, "toto", answers, "toto", player));
    }

}