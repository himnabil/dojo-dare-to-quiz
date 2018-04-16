package dojo.himnabil.dare2quiz.model;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class QuestionTest {
    private Player player = new Player("1", 1);
    private Player player2 = new Player("2", 1);

    @Test
    public void testConstructor() {
        Set<String> answers = new HashSet<>();
        answers.add("dgfqs");
        answers.add("toto");

        new Question(1, "toto", answers, "toto", player);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor__noValid() {
        Set<String> answers = new HashSet<>();
        answers.add("dgfqs");
        answers.add("toto");

        new Question(0, "toto", answers, "toto", player);

    }


}