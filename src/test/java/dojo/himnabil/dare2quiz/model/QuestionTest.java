package dojo.himnabil.dare2quiz.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class QuestionTest {
    private Player player = new Player("1", BigDecimal.TEN);
    private Player player2 = new Player("2", BigDecimal.TEN);

    @Test
    public void testConstructor() {
        Set<String> answers = new HashSet<>();
        answers.add("dgfqs");
        answers.add("toto");

        new Question(BigDecimal.TEN, "toto", answers, "toto", player);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor__noValid() {
        Set<String> answers = new HashSet<>();
        answers.add("dgfqs");
        answers.add("toto");

        new Question(BigDecimal.ZERO, "toto", answers, "toto", player);

    }


}