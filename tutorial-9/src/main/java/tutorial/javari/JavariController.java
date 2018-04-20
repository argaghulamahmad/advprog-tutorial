package tutorial.javari;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tutorial.javari.animal.Animal;

@RestController
public class JavariController {
    private JavariRecords records;

    public JavariController() throws IOException {
        records = new JavariRecords();
    }

    /**
     * Get animals as JSON format.
     * @return Object json data of animals or message
     */
    @GetMapping("/javari")
    public Object getAnimals() {
        List<Animal> animals;
        animals = records.getAnimals();
        if (animals == null || animals.isEmpty()) {
            return JsonMessage.getDatabaseEmptyMessage();
        }
        return animals;
    }

    /**
     * Get an animal by id as JSON format.
     * @param id int id of animal
     * @return Object json data of animal or message
     */
    @GetMapping("/javari/{id}")
    public Object getAnimalById(@PathVariable Integer id) {
        Animal animal;
        animal = records.getAnimalById(id);
        if (animal == null) {
            return JsonMessage.getNotFoundMessage(id);
        }
        return animal;
    }

    /**
     * Delete an animal by id.
     * @param id int id of animal want to delete
     * @return Object json data of deleted animal or message
     * @throws IOException exception
     */
    @DeleteMapping("/javari/{id}")
    public Object deleteAnimalById(@PathVariable Integer id) throws IOException {
        Animal animal;
        animal = records.deleteAnimalById(id);
        if (animal == null) {
            return JsonMessage.getNotFoundMessage(id);
        }

        return new Object[]{JsonMessage.getSuccessDeleteMessage(),animal};
    }

    /**
     * Create an animal.
     * @param json json data contains info of animal
     * @return Object json data
     * @throws IOException exception
     */
    @PostMapping("/javari")
    public Object createAnimal(@RequestBody String json) throws IOException {
        Animal animal;
        animal = records.addAnimal(json);

        return new Object[]{JsonMessage.getSuccessAddMessage(),animal};
    }
}

