package tutorial.javari;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tutorial.javari.animal.Animal;
import tutorial.javari.animal.Condition;
import tutorial.javari.animal.Gender;
import tutorial.reader.AnimalsRecordManager;

@RestController
public class JavariController {
    private AnimalsRecordManager recordManager;

    public JavariController() throws IOException {
        recordManager = new AnimalsRecordManager();
    }

    @GetMapping(value = "/javari")
    public String getJavari() throws IOException {
        System.out.println("GET JAVARI");
        return recordManager.recordsToJson();
    }

    @GetMapping(value = "/javari/{ID}")
    public String getJavariAnimal(@PathVariable(value = "ID") String id) throws IOException {
        System.out.println("GET JAVARI ANIMAL" + id);
        int parsedId = Integer.parseInt(id);
        return recordManager.animalToJson(parsedId);
    }

    @DeleteMapping(value = "/javari/{ID}")
    public String deleteJavariAnimal(@PathVariable(value = "ID") String id) throws IOException {
        System.out.println("DELETE JAVARI ANIMAL" + id);
        int parsedId = Integer.parseInt(id);
        return recordManager.removeAnimal(parsedId);
    }

    @PostMapping(value = "/javari", produces = "application/json")
    public void updateJavariAnimal(@RequestBody String jsonData) throws IOException {
        System.out.println("POST JAVARI ANIMAL");
        System.out.println(jsonData);
        JSONObject jsonObj = new JSONObject(jsonData);
        int id = (int) jsonObj.get("id");
        String type = (String) jsonObj.get("type");
        String name = (String) jsonObj.get("name");
        Gender gender = Gender.parseGender((String) jsonObj.get("gender"));
        Double length = (Double) jsonObj.get("length");
        Double weight = (Double) jsonObj.get("weight");
        Condition condition = Condition.parseCondition((String) jsonObj.get("condition"));
        boolean isSuccess =
                recordManager.addAnimal(new Animal(
                        id, type, name, gender, length, weight, condition));
        System.out.println(isSuccess ? "POST SUCCESS" : "POST FAILED");
    }
}