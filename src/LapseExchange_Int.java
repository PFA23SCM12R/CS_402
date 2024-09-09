import java.util.Random;

public class LapseExchange_Int {
    private static int randomValue;

    // Function to generate random matrix with integer values
    public static int[][] generateRandomMatrix(int rowCount, int colCount) {
        // Creating a matrix with the specified number of rows and columns
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
            System.out.println("Matrix cannot be multiplied. Please check the dimensions.");
        } else {
            int[][] resultMatrix = new int[matrixARows][matrixBCols];

            for (int i = 0; i < matrixARows; i++)
                for (int j = 0; j < matrixBCols; j++)
                    for (int k = 0; k < matrixBRows; k++) { // Interchanging matrixACols with matrixBRows
                        resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                    }

            // Printing the result matrix
            System.out.println("Result:");
            for (int i = 0; i < matrixARows; i++) {
                for (int j = 0; j < matrixBCols; j++) {
                    System.out.print(resultMatrix[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int matrixARows = 500, matrixACols = 300, matrixBRows = 300, matrixBCols = 600;
        int[][] matrix1 = new int[matrixARows][matrixACols];
        int[][] matrix2 = new int[matrixBRows][matrixBCols];

        // Start time
        long startTime = System.nanoTime();
        matrix1 = generateRandomMatrix(matrixARows, matrixACols);
        matrix2 = generateRandomMatrix(matrixBRows, matrixBCols);
        multiplyMatrices(matrix1, matrix2, matrixARows, matrixACols, matrixBRows, matrixBCols);
        // End time
        long endTime = System.nanoTime();
        // Time difference measured
        long timeElapsed = endTime - startTime;
        System.out.println("Time elapsed on Linux: " + timeElapsed + " nano seconds");
    }
}
