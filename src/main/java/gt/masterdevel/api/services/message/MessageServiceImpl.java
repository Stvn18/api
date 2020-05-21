package gt.masterdevel.api.services.message;

import gt.masterdevel.api.data.entities.Message;
import gt.masterdevel.api.data.entities.Tag;
import gt.masterdevel.api.data.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message getMessageById(Integer id) {
        return messageRepository.findById(id).orElse(new Message());
    }

    @Override
    public List<Message> doGetAllByTag(String name) {
        return messageRepository.doGetAllByTag(name);
    }

    @Override
    public Integer doCreateMessage(String msg, List<String> tags) {
        if ("".equals(msg) && tags.isEmpty()) {
            return -1;
        }

        Message message = new Message(msg);
        tags.forEach(tag -> message.addTag(new Tag(tag)));

        return messageRepository.save(message).getId();
    }
}
