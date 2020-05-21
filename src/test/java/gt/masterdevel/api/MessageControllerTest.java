package gt.masterdevel.api;

/*import gt.masterdevel.api.controllers.MessageController;
import gt.masterdevel.api.data.entities.Message;
import gt.masterdevel.api.services.message.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    private MessageController messageController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    @BeforeTestClass
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void getMessageByIdTest() throws Exception {

        Message message = new Message();
        message.setBody("Test");

        when(messageService.getMessageById(anyInt())).thenReturn(message);

        mockMvc.perform(MockMvcRequestBuilders.get("/message/1"))
                .andDo(print())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.body").value("Test"))
                .andExpect(status().isOk());

    }

}*/
