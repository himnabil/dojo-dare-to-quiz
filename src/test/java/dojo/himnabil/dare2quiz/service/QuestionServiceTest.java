package dojo.himnabil.dare2quiz.service;

import dojo.himnabil.dare2quiz.model.Player;
import dojo.himnabil.dare2quiz.model.Question;
import dojo.himnabil.dare2quiz.repository.PlayerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {
    @Mock
    private PlayerRepository playerRepository;
    @InjectMocks
    private QuestionService questionService;


    private Player player = new Player("1", 1);
    private Player player2 = new Player("2", 1);

    Set<String> answers = new HashSet<>();
    private Question question;

    @Before
    public void init(){
        when(playerRepository.getPlayer(anyString())).thenReturn(player2);
        answers.add("dgfqs");
        answers.add("toto");
        question = new Question(1, "toto", answers, "toto", player);
    }

    @Test
    public void askQuestion() {
        questionService.askQuestion("2", question);
    }

    @Test
    public void answerQuestion_withCorrectAnswer() {
        String playerId = "playerId";

        Player t = new Player(playerId);
        t.getQuestions().add(question);
        when(playerRepository.getPlayer(anyString())).thenReturn(t);

        boolean b = questionService.answerQuestion(playerId, "toto");
        Assert.assertTrue(b);
    }

    @Test
    public void answerQuestion_withBadAnswer() {
        String playerId = "playerId";

        Player t = new Player(playerId);
        t.getQuestions().add(question);
        when(playerRepository.getPlayer(anyString())).thenReturn(t);

        boolean b = questionService.answerQuestion(playerId, "dgfqs");
        Assert.assertFalse(b);
    }

    @Test
    public void answerQuestion_withAnswerNotInList() {
        String playerId = "playerId";

        Player t = new Player(playerId);
        t.getQuestions().add(question);
        when(playerRepository.getPlayer(anyString())).thenReturn(t);

        boolean b = questionService.answerQuestion(playerId, "aze");
        Assert.assertFalse(b);
    }

    @Test(expected = IllegalStateException.class)
    public void answerQuestion_withOutQuestions() {

        boolean b = questionService.answerQuestion("playerId", "titi");

    }

}