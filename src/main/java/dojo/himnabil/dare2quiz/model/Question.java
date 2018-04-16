package dojo.himnabil.dare2quiz.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.util.Assert;

import java.util.Set;

@Value
@Builder
public class Question {
    public Question(long nbCoins, String value, Set<String> answers, String validAnswer, Player owner) {
        Assert.isTrue(nbCoins > 0, "nbCoins > 0");
        Assert.notEmpty(answers, "answers should not be empty.");
        Assert.notNull(validAnswer, "validAnswer should not be null.");
        Assert.notNull(owner, "owner should not be null.");
        Assert.isTrue(answers.contains(validAnswer), "answers should contain validAnswer.");
        this.nbCoins = nbCoins;
        this.value = value;
        this.answers = answers;
        this.validAnswer = validAnswer;
        this.owner = owner;
    }

    private long nbCoins;
    private String value;
    private Set<String> answers;
    private String validAnswer;
    private Player owner;
}
