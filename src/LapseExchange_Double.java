
import java.util.Random;

public class LapseExchange_Double {

    // Function to generate a random matrix with double values
    public static double[][] generateRandomMatrix(int rowCount, int colCount){
        double randomValue;
        // Creating a matrix with given rows and columns
        double[][] matrix = new double[rowCount][colCount];
        // Creating an instance of the Random class
        Random random = new Random();
        // Inserting random values into the matrix
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                randomValue = random.nextDouble() * 100.0;
                System.out.println(randomValue);
                matrix[i][j] = randomValue;
            }
        }
        return matrix;
    }

    // Function to multiply two double matrices
    private static void multiplyMatrices(double[][] matrixA, double[][] matrixB, int matrixARows, int matrixACols, int matrixBRows, int matrixBCols){

        if(matrixACols != matrixBRows) {
            System.out.println("Matrix multiplication is not possible. Please check the dimensions.");
        }
        else {
            double[][] resultMatrix = new double[matrixARows][matrixBCols];

            for(int i = 0; i < matrixARows; i++)
                for(int j = 0; j < matrixBCols; j++)
                    for(int k = 0; k < matrixBRows; k++) { // Interchanging matrixACols with matrixBRows
                        resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                    }

            // Printing the result
            System.out.println("Result:");
            for(int i = 0; i < matrixARows; i++) {
                for(int j = 0; j < matrixBCols; j++) {
                    System.out.print(resultMatrix[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int matrixARows = 500, matrixACols = 300, matrixBRows = 300, matrixBCols = 600;
        double[][] matrix1 = new double[matrixARows][matrixACols];
        double[][] matrix2 = new double[matrixBRows][matrixBCols];

        // Start time
        long startTime = System.nanoTime();
        matrix1 = generateRandomMatrix(matrixARows, matrixACols);
        matrix2 = generateRandomMatrix(matrixBRows, matrixBCols);
        multiplyMatrices(matrix1, matrix2, matrixARows, matrixACols, matrixBRows, matrixBCols);
        // End time
        long endTime = System.nanoTime();
        // Time difference measured
        long timeElapsed = endTime - startTime;
        System.out.println("Time elapsed on windows: " + timeElapsed + " nano seconds");

    }
}
