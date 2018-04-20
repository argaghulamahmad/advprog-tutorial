package tutorial.javari;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.opencsv.CSVReader;
import org.json.JSONObject;

import tutorial.javari.animal.Animal;
import tutorial.javari.animal.AnimalComparator;
import tutorial.javari.animal.Condition;
import tutorial.javari.animal.Gender;

public class JavariRecords {

    private List<Animal> animals;
    /*private static final String ANIMAL_RECORDS_PATH = "./tutorial-9/data/animals_records.csv";*/
    private static final String ANIMAL_RECORDS_PATH = "animals_records.csv";
    private final Path file = Paths.get("", ANIMAL_RECORDS_PATH);

    public JavariRecords() throws IOException {
        animals = new ArrayList<>();
        loadData();
    }

    /**
     * Get list of animals.
     * @return List of animals
     */
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Get an animal.
     * @param id id of animal
     * @return Animal animal object
     */
    public Animal getAnimalById(int id) {
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
    public Animal addAnimal(String json) throws IOException {
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
    public Animal deleteAnimalById(int id) throws IOException {
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
        try (
                Reader reader = Files.newBufferedReader(Paths.get(ANIMAL_RECORDS_PATH));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            List<String[]> csvData = csvReader.readAll();

            csvData.forEach(record -> {
                String joinedRecord = String.join(",", record);
                animals.add(csvToAnimal(joinedRecord));
            });
        }
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
        return new Animal(json.getInt("id"), json.getString("type"),
                json.getString("name"),
                Gender.parseGender(json.getString("gender")),
                json.getDouble("length"), json.getDouble("weight"),
                Condition.parseCondition(json.getString("condition")));
    }

    /**
     * Csv to animal object .
     * @param csvInput string of csv data
     * @return Animal object of animal
     */
    private Animal csvToAnimal(String csvInput) {
        String[] attrs = csvInput.split(",");
        return new Animal(Integer.parseInt(attrs[0]),
                attrs[1], attrs[2], Gender.parseGender(attrs[3]),
                Double.parseDouble(attrs[4]), Double.parseDouble(attrs[5]),
                Condition.parseCondition(attrs[7]));
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
