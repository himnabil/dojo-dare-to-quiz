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

    private PlayerService playerService;
    private PlayerRepository playerRepository;

    public BigDecimal loss(Question question) {
        return question.getNbCoins().divide(new BigDecimal(question.getAnswers().size()), HALF_UP);
    }

    public void askQuestion(String askedPlayerId, Question question) {
        BigDecimal mise = question.getNbCoins();
        BigDecimal dispo = question.getOwner().getNbCoins();
        BigDecimal nbCoinsLeft = dispo.subtract(mise);
        if (nbCoinsLeft.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Insufficient coins");
        }
        Player askedPlayer = playerService.getOrCreate(askedPlayerId);

        if (askedPlayer.getNbCoins().compareTo(loss(question)) < 0) {
            throw new RuntimeException("Asked player Insufficient coins");
        }

        String ownerPlayerId = question.getOwner().getId();
        Player owner = playerService.getOrCreate(ownerPlayerId);
        owner.setNbCoins(nbCoinsLeft);

        playerRepository.save(owner);

        askedPlayer.getQuestions().add(question);

        playerRepository.save(askedPlayer);
    }

    public boolean answerQuestion(String playerId, String answer) {
        Player asked = playerService.getOrCreate(playerId);
        Question question = asked.getQuestions().poll();
        if (question == null) {
            throw new IllegalStateException("No question left");
        }


        Player owner = playerService.getOrCreate(question.getOwner().getId());
        boolean result = answer.equals(question.getValidAnswer());
        if (result) {
            BigDecimal add = asked.getNbCoins().add(question.getNbCoins());
            asked.setNbCoins(add);
        } else {
            BigDecimal loss = loss(question);
            BigDecimal minus = asked.getNbCoins().subtract(loss);
            BigDecimal plus = owner.getNbCoins().add(loss);
            asked.setNbCoins(minus);
            owner.setNbCoins(plus);
        }

        playerRepository.save(owner);
        playerRepository.save(asked);

        return result;
    }

    public Question getCurrentQuestion(String askedId) {
        return playerService.getOrCreate(askedId).getQuestions().peek();
    }
}
