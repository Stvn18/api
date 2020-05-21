package gt.masterdevel.api.data.repo;

import gt.masterdevel.api.data.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("SELECT tg.message" +
            " FROM Tag tg" +
            " WHERE tg.name = :name")
    List<Message> doGetAllByTag(@Param("name") String name);
}
