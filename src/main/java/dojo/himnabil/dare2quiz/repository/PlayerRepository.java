package dojo.himnabil.dare2quiz.repository;

import dojo.himnabil.dare2quiz.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, String> {


}
