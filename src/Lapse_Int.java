import java.util.Random;

public class Lapse_Int {
    private static int randomValue;

    // Function to generate random matrix with integer values
    public static int[][] generateRandomMatrix(int rowCount, int colCount) {
        // Creating a matrix with the given rows and columns
        int[][] matrix = new int[rowCount][colCount];

        // Creating a new instance of the Random class
        Random random = new Random();

        // Inserting random values into the matrix
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                randomValue = random.nextInt(100);
                System.out.println(randomValue);
                matrix[i][j] = randomValue;
            }
        }
        return matrix;
    }

    // Function to multiply two integer matrices
    private static void multiplyMatrices(int[][] matrixA, int[][] matrixB, int matrixARows, int matrixACols, int matrixBRows, int matrixBCols) {

        if (matrixACols != matrixBRows) {
            System.out.println("Matrix multiplication is not possible. Please check the dimensions.");
        } else {
            int[][] resultMatrix = new int[matrixARows][matrixBCols];

            for (int i = 0; i < matrixARows; i++)
                for (int j = 0; j < matrixBCols; j++)
                    for (int k = 0; k < matrixACols; k++) {
                        resultMatrix[i][j] = matrixA[i][k] * matrixB[k][j];
                    }

            // Printing the result matrix
            for (int i = 0; i < matrixARows; i++) {
                for (int j = 0; j < matrixBCols; j++) {
                    System.out.print(resultMatrix[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        int firstMatrixRows = 500, firstMatrixCols = 300, secondMatrixRows = 300, secondMatrixCols = 600;
        int[][] matrix1 = new int[firstMatrixRows][firstMatrixCols];
        int[][] matrix2 = new int[secondMatrixRows][secondMatrixCols];

        // Start time
        long startTime = System.nanoTime();
        matrix1 = generateRandomMatrix(firstMatrixRows, firstMatrixCols);
        matrix2 = generateRandomMatrix(secondMatrixRows, secondMatrixCols);
        System.out.println("Answer:");
        multiplyMatrices(matrix1, matrix2, firstMatrixRows, firstMatrixCols, secondMatrixRows, secondMatrixCols);
        // End time
        long endTime = System.nanoTime();
        // Time difference measured
        long timeElapsed = endTime - startTime;
        System.out.println("Time elapsed on Windows: " + timeElapsed + " nano seconds");

    }
}

