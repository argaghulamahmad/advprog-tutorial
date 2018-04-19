package tutorial.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import tutorial.javari.animal.Animal;
import tutorial.javari.animal.Condition;
import tutorial.javari.animal.Gender;

public class AnimalsRecordManager {
    private static final String ANIMAL_RECORDS_PATH = "./tutorial-9/data/animals_records.csv";

    public static List<String[]> getDataFromCsv() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(ANIMAL_RECORDS_PATH));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            return csvReader.readAll();
        }
    }

    public static ArrayList<Animal> convertRecordsToAnimal(List<String[]> records) {
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

    /*public static void printAll() throws IOException {
        ArrayList<Animal> records = convertRecordsToAnimal(getDataFromCsv());
        records.forEach(System.out::println);
    }*/

    public static String recordsToJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return objectMapper.writeValueAsString(convertRecordsToAnimal(getDataFromCsv()));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(recordsToJson());
    }
}
