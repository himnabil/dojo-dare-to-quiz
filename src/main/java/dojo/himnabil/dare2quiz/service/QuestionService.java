package dojo.himnabil.dare2quiz.service;

import dojo.himnabil.dare2quiz.model.Player;
import dojo.himnabil.dare2quiz.model.Question;
import dojo.himnabil.dare2quiz.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class QuestionService {

    private PlayerRepository playerRepository;

    public void askQuestion(String askedPlayerId,  Question question) {
        long mise = question.getNbCoins();
        long dispo = question.getOwner().getNbCoins();
        if (dispo - mise <0) {
            throw new RuntimeException("Insufficient coins");
        }

        playerRepository.getPlayer(askedPlayerId).getQuestions().add(question);
    }

    public boolean answerQuestion(String playerId, String answer) {
        Player player = playerRepository.getPlayer(playerId);
        Question poll = player.getQuestions().poll();
        if (poll == null) {
            throw new IllegalStateException("No question left");
        }
        //TODO Gérer les mises
        return answer.equals(poll.getValidAnswer());
    }

}
