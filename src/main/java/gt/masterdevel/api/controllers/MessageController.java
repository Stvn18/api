package gt.masterdevel.api.controllers;

import gt.masterdevel.api.data.dto.MessageBodyDto;
import gt.masterdevel.api.data.entities.Message;
import gt.masterdevel.api.services.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * Get message by ID
     * @param id ID message
     * @return Message
     */
    @GetMapping("/message/{id}")
    public ResponseEntity<Message> doGetMessageById(@PathVariable Integer id) {
        return new ResponseEntity<>(messageService.getMessageById(id), HttpStatus.OK);
    }

    /**
     * Get messages by tag
     * @param tag Tag message
     * @return List of message by tag
     */
    @GetMapping("/messages/{tag}")
    public ResponseEntity<List<Message>> doGetMessagesByTag(@PathVariable String tag) {
        return new ResponseEntity<>(messageService.doGetAllByTag(tag), HttpStatus.OK);
    }

    /**
     * Create new message
     * @param msg Msg body
     * @param messageBodyTags List tags message
     * @return Unique identifier
     */
    @PostMapping("/message")
    public ResponseEntity<Integer> doCreateMessage(
            @RequestParam("msg") String msg,
            @RequestBody MessageBodyDto messageBodyTags
    ) {
        Integer id = messageService.doCreateMessage(msg, messageBodyTags.getTags());

        if (id == -1) {
            return new ResponseEntity<>(id, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
