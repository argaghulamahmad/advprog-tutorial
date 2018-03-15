package hello;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ResumeController.class)
public class ResumeTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void resumeWithVisitor() throws Exception {
        String test = "Arga, I hope you interested to hire me";
        mockMvc.perform(get("/resume").param("visitor", "Arga"))
                .andExpect(content().string(containsString(test)));

        mockMvc.perform(get("/resume").param("visitor", ""))
                .andExpect(content().string(containsString("This is my CV")));
    }

    @Test(expected = AssertionError.class)
    public void resumeWithVisitorNegative() throws Exception {
        String test = "Arga, I hope you interested to hire me";
        mockMvc.perform(get("/resume").param("visitor", ""))
                .andExpect(content().string(containsString(test)));

        mockMvc.perform(get("/resume").param("visitor", "Arga"))
                .andExpect(content().string(containsString("This is my CV")));
    }

}

