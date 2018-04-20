package tutorial.javari;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tutorial.javari.animal.Animal;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JavariControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private JavariRecords javariRecords = new JavariRecords();
    private int sampleId = 5;
    private Animal sampleAnimal = javariRecords.getAnimalById(sampleId);
    private String sampleJson = animalToJson(sampleAnimal);

    public JavariControllerTest() throws IOException, JSONException {
    }

    public String animalToJson(Animal animal) throws JSONException {
        return new JSONObject().put("id", animal.getId())
                .put("type", animal.getType())
                .put("name", animal.getName())
                .put("gender", animal.getGender())
                .put("length", animal.getLength())
                .put("weight", animal.getWeight())
                .put("condition", animal.getCondition())
                .toString();
    }

    @Test
    public void getAnimalByIdTest() throws Exception {
        this.mockMvc.perform(get("/javari/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("3"));
    }

    @Test
    public void getByIdNotFoundTest() throws Exception {
        this.mockMvc.perform(get("/javari/98"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msgType").value("warning"));
    }

    @Test
    public void getAllAnimalsTest() throws Exception {
        this.mockMvc.perform(get("/javari"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].id").value("2"));
    }


    /**
        Restore database.
     */
    @Test
    public void deleteAndAddTest() throws Exception {
        deleteByIdTest();
        addAnimalTest();
    }

    public void deleteByIdTest() throws Exception {
        this.mockMvc.perform(delete("/javari/" + sampleId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].msgType").value("success"))
                .andExpect(jsonPath("$[1].id").value(sampleId));

        this.mockMvc.perform(get("/javari/" + sampleId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.msgType").value("warning"));
    }

    public void addAnimalTest() throws Exception {
        this.mockMvc.perform(post("/javari").content(sampleJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].msgType").value("success"))
                .andExpect(jsonPath("$[1].id").value(sampleId));

        this.mockMvc.perform(get("/javari/" + sampleId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(sampleId));
    }
}