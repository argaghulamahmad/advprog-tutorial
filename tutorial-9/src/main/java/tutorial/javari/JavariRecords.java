package tutorial.javari;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;
import tutorial.javari.animal.Animal;
import tutorial.javari.animal.AnimalComparator;
import tutorial.javari.animal.Condition;
import tutorial.javari.animal.Gender;

class JavariRecords {

    private List<Animal> animals;
    /*private static final String ANIMAL_RECORDS_PATH = "./tutorial-9/data/animals_records.csv";*/
    private static final String ANIMAL_RECORDS_PATH = "animals_records.csv";
    private final Path file = Paths.get("", ANIMAL_RECORDS_PATH);

    JavariRecords() throws IOException {
        animals = new ArrayList<>();
        loadData();
    }

    /**
     * Get list of animals.
     * @return List of animals
     */
    List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Get an animal.
     * @param id id of animal
     * @return Animal animal object
     */
    Animal getAnimalById(int id) {
        AnimalComparator ac = new AnimalComparator();
        animals.sort(ac);
        int index = Collections.binarySearch(animals, new Animal(id));

        return index >= 0 ? animals.get(index) : null;
    }

    /**
     * Add animal.
     * @param json json data of animal want to add
     * @return Animal animal object
     * @throws IOException exception
     */
    Animal addAnimal(String json) throws IOException {
        Animal newAnimal = jsonToAnimal(json);
        if (!duplicateId(newAnimal)) {
            animals.add(newAnimal);
            saveData();
            return newAnimal;
        }
        return null;
    }

    /**
     * Delete animal from list.
     * @param id int id of animal want to delete
     * @return Animal object of animal
     * @throws IOException exception
     */
    Animal deleteAnimalById(int id) throws IOException {
        AnimalComparator ac = new AnimalComparator();
        animals.sort(ac);
        int index = Collections.binarySearch(animals, new Animal(id));

        Animal animal = null;

        if (index >= 0) {
            animal = animals.remove(index);
        } else {
            saveData();
        }

        return animal;
    }

    /**
     * Load data from csv animal records.
     * @throws IOException exception
     */
    private void loadData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file.toString()));
        String line = reader.readLine();

        while (line != null) {
            animals.add(csvToAnimal(line));
            line = reader.readLine();
        }

        reader.close();
    }

    /**
     * Save modified list to csv.
     * @throws IOException  exception
     */
    private void saveData() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.toString()));

        for (Animal animal : animals) {

            String csv = animalToCsv(animal);

            writer.write(csv);
            writer.newLine();
        }
        writer.close();
    }

    /**
     * Check if there is no duplicate id.
     * @param subject animal want to check
     * @return boolean
     */
    private boolean duplicateId(Animal subject) {
        for (Animal animal : animals) {
            if (animal.getId().equals(subject.getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Convert json to animal.
     * @param input json string
     * @return Animal object of animal
     */
    private Animal jsonToAnimal(String input) {
        JSONObject json = new JSONObject(input);

        int id = json.getInt("id");
        String type = json.getString("type");
        String name = json.getString("name");
        Gender gender = Gender.parseGender(json.getString("gender"));
        double length = json.getDouble("length");
        double weight = json.getDouble("weight");
        Condition condition = Condition.parseCondition(json.getString("condition"));

        return new Animal(id, type, name, gender, length, weight, condition);
    }

    /**
     * Csv to animal object .
     * @param csvInput string of csv data
     * @return Animal object of animal
     */
    private Animal csvToAnimal(String csvInput) {
        String[] attrs = csvInput.split(",");

        int id = Integer.parseInt(attrs[0]);
        String type = attrs[1];
        String name = attrs[2];
        Gender gender = Gender.parseGender(attrs[3]);
        double length = Double.parseDouble(attrs[4]);
        double weight = Double.parseDouble(attrs[5]);
        Condition condition = Condition.parseCondition(attrs[6]);

        return new Animal(id, type, name, gender, length, weight, condition);
    }

    /**
     * Convert to animal csv.
     * @param animal String of animal
     * @return String of csv data
     */
    private String animalToCsv(Animal animal) {
        String[] attrs = {animal.getId().toString(), animal.getType(),
                animal.getName(), animal.getGender().toString(),
                String.valueOf(animal.getLength()),
                String.valueOf(animal.getWeight()),
                animal.getCondition().toString()};
        return String.join(",", attrs);
    }

}
