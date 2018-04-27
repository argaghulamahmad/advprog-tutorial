package matrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static String genericMatrixPath = "plainTextDirectory/input/matrixProblem";
    private static String pathFileMatrix1 = genericMatrixPath + "A/matrixProblemSet1.txt";
    private static int numberOfLine1 = 50;

    private static String pathFileMatrix2 = genericMatrixPath + "A/matrixProblemSet2.txt";
    private static int numberOfLine2 = 50;

    public static String getGenericMatrixPath() {
        return genericMatrixPath;
    }

    public static void setGenericMatrixPath(String genericMatrixPath) {
        Main.genericMatrixPath = genericMatrixPath;
    }

    public static String getPathFileMatrix1() {
        return pathFileMatrix1;
    }

    public static void setPathFileMatrix1(String pathFileMatrix1) {
        Main.pathFileMatrix1 = pathFileMatrix1;
    }

    public static int getNumberOfLine1() {
        return numberOfLine1;
    }

    public static void setNumberOfLine1(int numberOfLine1) {
        Main.numberOfLine1 = numberOfLine1;
    }

    public static String getPathFileMatrix2() {
        return pathFileMatrix2;
    }

    public static void setPathFileMatrix2(String pathFileMatrix2) {
        Main.pathFileMatrix2 = pathFileMatrix2;
    }

    public static int getNumberOfLine2() {
        return numberOfLine2;
    }

    public static void setNumberOfLine2(int numberOfLine2) {
        Main.numberOfLine2 = numberOfLine2;
    }

    public static void main(String[] args) throws
            IOException, InvalidMatrixSizeForMultiplicationException {

        //Convert into array
        double[][] firstMatrix = convertInputFileToMatrix(pathFileMatrix1, numberOfLine1,
                numberOfLine1);
        double[][] secondMatrix = convertInputFileToMatrix(pathFileMatrix2, numberOfLine2,
                numberOfLine1);

        System.out.printf(
                "Basic square matrix multiplication, matrix 1: %s, matrix 2: %s, "
                        + "total run time: %d ms\n",
                pathFileMatrix1, pathFileMatrix2,
                benchmarkMultiplicationBasic(firstMatrix, secondMatrix));

        System.out.printf(
                "Strassen square matrix multiplication, matrix 1: %s, matrix 2: %s, "
                        + "total run time: %d ms\n",
                pathFileMatrix1, pathFileMatrix2,
                benchmarkMultiplicationStrassen(firstMatrix, secondMatrix));

    }

    private static long benchmarkMultiplicationBasic(double[][] matrix1, double[][] matrix2)
            throws InvalidMatrixSizeForMultiplicationException {
        long start = System.currentTimeMillis();
        MatrixOperation.basicMultiplicationAlgorithm(matrix1, matrix2);
        return System.currentTimeMillis() - start;
    }

    private static long benchmarkMultiplicationStrassen(double[][] matrix1, double[][] matrix2) {
        long start = System.currentTimeMillis();
        MatrixOperation.strassenMatrixMultiForNonSquareMatrix(matrix1, matrix2);
        return System.currentTimeMillis() - start;
    }

    /**
     * Converting a file input into an 2 dimensional array of double that represent a matrix.
     * @param pathFile is a path to file input.
     * @param numberOfRow the number of row (and possibly column) inside the square matrix.
     * @return 2 dimensional array of double representing matrix.
     * @throws IOException in the case of the file is not found because of the wrong path of file.
     */
    public static double[][] convertInputFileToMatrix(String pathFile,
                                                      int numberOfRow,
                                                      int numberOfColumn)
            throws IOException {
        File matrixFile = new File(pathFile);
        FileReader fileReader = new FileReader(matrixFile);
        double[][] matrix = new double[numberOfRow][numberOfColumn];

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String currentLine;
        int indexOfLine = 0;
        while ((currentLine = bufferedReader.readLine()) != null) {
            matrix[indexOfLine] = sequenceIntoArray(currentLine);
            indexOfLine++;
        }
        return matrix;
    }

    /**
     * Converting a row of sequence of double into an array.
     * @param currentLine sequence of double from input representing a row from matrix.
     * @return array of double representing a row from matrix.
     */
    private static double[] sequenceIntoArray(String currentLine) {
        String[] arrInput = currentLine.split(" ");
        double[] arrInteger = new double[arrInput.length];
        for (int index = 0; index < arrInput.length; index++) {
            arrInteger[index] = Double.parseDouble(arrInput[index]);
        }
        return arrInteger;
    }
}
