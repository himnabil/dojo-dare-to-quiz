package dojo.himnabil.dare2quiz.service;

import dojo.himnabil.dare2quiz.model.Player;
import dojo.himnabil.dare2quiz.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class QuestionService {

    private Map<String, Player> playersById;

    public void askQuestion(String askedId,  Question question) {
        long mise = question.getNbCoins();
        long dispo = question.getOwner().getNbCoins();
        if (dispo - mise <0) {
//            throw new exception....
        }

        if (playersById.containsKey(askedId)) {
            playersById.get(askedId).getQuestions().add(question);
        } else {
            Player player= Player.builder().id(askedId).build();
            player.getQuestions().add(question);
            playersById.put(askedId, player);

            log.info("new player with id {} created", askedId);

        }
    }
}
