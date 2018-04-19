package tutorial.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;
import tutorial.javari.animal.Animal;
import tutorial.javari.animal.AnimalComparator;
import tutorial.javari.animal.Condition;
import tutorial.javari.animal.Gender;

public class AnimalsRecordManager {
    private static final String ANIMAL_RECORDS_PATH = "./tutorial-9/data/animals_records.csv";
    private ArrayList<Animal> animals = new ArrayList<>();

    public AnimalsRecordManager() throws IOException {
        refreshRecords();
    }

    /**
     * Convert data from csv to list.
     * @return List list contains array strings of data
     * @throws IOException exception
     */
    private List<String[]> getDataListFromCsv() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(ANIMAL_RECORDS_PATH));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            return csvReader.readAll();
        }
    }

    /**
     * Convert records to arraylist of animals.
     * @param records list of arrays strings of records
     * @return ArrayList list contains animal object
     */
    private ArrayList<Animal> convertRecordsToAnimals(List<String[]> records) {
        ArrayList<Animal> animals = new ArrayList<>();
        records.forEach(record -> {
            int id = Integer.parseInt(record[0]);
            String type = record[1];
            String name = record[2];
            Gender gender = Gender.parseGender(record[3]);
            double length = Double.parseDouble(record[4]);
            double weight = Double.parseDouble(record[5]);
            Condition condition = Condition.parseCondition(record[7]);
            animals.add(new Animal(id, type, name, gender, length, weight, condition));
        });

        return animals;
    }

    /**
     * Reset list data state to initial csv data.
     * @throws IOException exception
     */
    private void refreshRecords() throws IOException {
        animals = convertRecordsToAnimals(getDataListFromCsv());
    }

    /**
     * Convert object to json format.
     * @param obj obj want to convert
     * @return converted object as json format
     * @throws IOException exception
     */
    private String objectToJson(Object obj) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return objectMapper.writeValueAsString(obj);
    }

    /**
     * Convert records to json data.
     * @return String of json data or warning message
     * @throws IOException exception
     */
    public String recordsToJson() throws IOException {
        if (animals.isEmpty()) {
            JSONObject message = new JSONObject();
            message.put("messageType", "warning");
            message.put("message", "Animals list is empty!");
            return String.valueOf(message);
        }
        return objectToJson(animals);
    }

    /**
     * Convert an animal to json data.
     * @param id int id of animal
     * @return json data of animal or warning message
     * @throws IOException exception
     */
    public String animalToJson(int id) throws IOException {
        AnimalComparator ac = new AnimalComparator();
        animals.sort(ac);
        int index = Collections.binarySearch(animals, new Animal(id));
        if (index >= 0) {
            Animal animal = animals.get(index);
            return objectToJson(animal);
        } else {
            JSONObject message = new JSONObject();
            message.put("messageType", "warning");
            message.put("message", "Animal not exists!");
            return String.valueOf(message);
        }
    }

    /**
     * Remove an animal from animals list.
     * @param id int id of animal
     * @return json data of animal or warning message
     * @throws IOException exception
     */
    public String removeAnimal(int id) throws IOException {
        AnimalComparator ac = new AnimalComparator();
        animals.sort(ac);
        int index = Collections.binarySearch(animals, new Animal(id));
        System.out.println("Index : " + index);
        String result = animalToJson(id);
        animals.remove(new Animal(id));
        return result;
    }

    /**
     * Add animal to list.
     * @param animal Object of an animal
     * @return boolean success or false
     */
    public boolean addAnimal(Animal animal) {
        if (!animals.contains(animal)) {
            animals.add(animal);
            return true;
        }
        return false;
    }
}
