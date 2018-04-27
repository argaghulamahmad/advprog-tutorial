package matrix;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class MatrixMultiplicationTest {

    private double[][] matrix1a;
    private double[][] matrix1b;
    private double[][] expected1;

    @Before
    public void setUp() throws IOException {
        matrix1a = Main.convertInputFileToMatrix(Main.getPathFileMatrix1(), Main.getNumberOfLine1(),
                Main.getNumberOfLine1());
        matrix1b = Main.convertInputFileToMatrix(Main.getPathFileMatrix2(), Main.getNumberOfLine2(),
                Main.getNumberOfLine1());
        expected1 = Main.convertInputFileToMatrix(Main.getGenericMatrixPath()
                + "A/matrixResult.txt", 50, 50);
    }

    @Test
    public void basicMultiplication() throws InvalidMatrixSizeForMultiplicationException {
        assertArrayEquals(MatrixOperation.basicMultiplicationAlgorithm(matrix1a, matrix1b),
                expected1);
    }

    @Test
    public void strassenMultiplication() {
        assertArrayEquals(MatrixOperation.strassenMatrixMultiForNonSquareMatrix(matrix1a,
                matrix1b), expected1);
    }

    @Test
    public void convertNonSquareMatrix() throws IOException {
        Main.convertInputFileToMatrix(Main.getGenericMatrixPath() + "B/matrix10rows50columns.txt",
                50, 10);
    }

}
