package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static String pathFile = "plainTextDirectory/input/sortingProblem.txt";
    private static int numberOfItemToBeSorted = 50000;

    public static void main(String[] args) throws IOException {

        int[] sequenceInput = convertInputFileToArray();

        //Searching Input Before Sorting
        long totalMilisSearchBeforeSort = System.currentTimeMillis();
        int searchingResultBeforeSort = Finder.quickSearch(sequenceInput, 40738);
        totalMilisSearchBeforeSort = System.currentTimeMillis() - totalMilisSearchBeforeSort;
        System.out.println("Searching Complete in " + totalMilisSearchBeforeSort + " milisecond");

        //Sorting Input
        long totalMilisSorting = System.currentTimeMillis();
        int[] sortedInput = Sorter.quickSort(sequenceInput);
        totalMilisSorting = System.currentTimeMillis() - totalMilisSorting;
        System.out.println("(Quick) Sorting Complete in " + totalMilisSorting + " milisecond");

        //Searching Input After Sorting
        long totalMilisSearchAfterSort = System.currentTimeMillis();
        int searchingResultAfterSort = Finder.quickSearch(sequenceInput, 40738);
        totalMilisSearchAfterSort = System.currentTimeMillis() - totalMilisSearchAfterSort;
        System.out.println("Searching Complete in " + totalMilisSearchAfterSort + " milisecond");
    }

    /**
     * Converting a file input into an array of integer.
     * @return an array of integer that represent an integer sequence.
     * @throws IOException in the case of the file is not found because of the wrong path of file.
     */
    private static int[] convertInputFileToArray() throws IOException {
        File sortingProblemFile = new File(pathFile);
        FileReader fileReader = new FileReader(sortingProblemFile);
        int[] sequenceInput = new int[numberOfItemToBeSorted];

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String currentLine;
        int indexOfSequence = 0;
        while ((currentLine = bufferedReader.readLine()) != null) {
            sequenceInput[indexOfSequence] = Integer.parseInt(currentLine);
            indexOfSequence++;
        }
        return sequenceInput;
    }
}
