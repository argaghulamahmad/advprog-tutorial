package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = Application.class)
public class RoutingTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void index() throws Exception {
        mockMvc.perform(get("/").param("name", "Greg"))
                .andExpect(content().string(containsString("Welcome to my resume web based, please enter your name.")));
    }

}
