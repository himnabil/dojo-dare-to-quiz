package dojo.himnabil.dare2quiz.service;

import dojo.himnabil.dare2quiz.model.Player;
import dojo.himnabil.dare2quiz.model.Question;
import dojo.himnabil.dare2quiz.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

@Service
@Slf4j
@AllArgsConstructor
public class QuestionService {

    private PlayerRepository playerRepository;

    public BigDecimal loss(Question question){
        return question.getNbCoins().divide(new BigDecimal(question.getAnswers().size()), HALF_UP);
    }

    public void askQuestion(String askedPlayerId,  Question question) {
        BigDecimal mise = question.getNbCoins();
        BigDecimal dispo = question.getOwner().getNbCoins();
        BigDecimal nbCoinsLeft = dispo.subtract(mise);
        if (nbCoinsLeft.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Insufficient coins");
        }
        Player askedPlayer = playerRepository.getPlayer(askedPlayerId);

        if (askedPlayer.getNbCoins().compareTo(loss(question)) < 0) {
            throw new RuntimeException("Asked player Insufficient coins");
        }

        String ownerPlayerId =  question.getOwner().getId();
        playerRepository.getPlayer(ownerPlayerId).setNbCoins(nbCoinsLeft);

        askedPlayer.getQuestions().add(question);
    }

    public boolean answerQuestion(String playerId, String answer) {
        Player askee = playerRepository.getPlayer(playerId);
        Question question = askee.getQuestions().poll();
        if (question == null) {
            throw new IllegalStateException("No question left");
        }


        Player asker = playerRepository.getPlayer(question.getOwner().getId());
        boolean result = answer.equals(question.getValidAnswer());
        if (result) {
            BigDecimal add = askee.getNbCoins().add(question.getNbCoins());
            askee.setNbCoins(add);
        } else {
            BigDecimal loss = loss(question);
            BigDecimal minus = askee.getNbCoins().subtract(loss);
            BigDecimal plus = asker.getNbCoins().add(loss);
            askee.setNbCoins(minus);
            asker.setNbCoins(plus);
        }

        return result;
    }

    public Question getCurrentQuestion(String askedId) {
        return playerRepository.getPlayer(askedId).getQuestions().peek();
    }
}
