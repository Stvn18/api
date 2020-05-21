package gt.masterdevel.api.services.message;

import gt.masterdevel.api.data.entities.Message;

import java.util.List;

public interface MessageService {
    Message getMessageById(Integer id);
    List<Message> doGetAllByTag(String name);
    Integer doCreateMessage(String msg, List<String> tags);
}
