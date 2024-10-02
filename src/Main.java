import java.util.Random;

/**
 * Створює дві матриці розміром 5*5, заповнені випадковими числами типу Short.
 * Виконує над матрицями операцію XOR. Розраховує суму найменших чисел в рядках
 * результуючої матриці. Виводить в консоль початкові матриці, результуючу матрицю
 * та суму.
 */
public class Main {
    public static void main(String[] args) {

        // Створює, заповнює та виводить матрицю A
        short[][] a = new short[5][5];
        randomizeMatrix(a);
        System.out.println("A:");
        printMatrix(a);

        // Створює, заповнює та виводить матрицю B
        short[][] b = new short[5][5];
        randomizeMatrix(b);
        System.out.println("B:");
        printMatrix(b);

        // Створює, розраховує як A XOR B та виводить матрицю C
        short[][] c = new short[5][5];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = (short) (a[i][j] ^ b[i][j]);
            }
        }
        System.out.println("C:");
        printMatrix(c);

        // Розраховує та виводить суму найменших елементів рядків матриці C
        short sumOfMin = 0;
        for (short[] row : c) {
            short min = row[0];
            for (short value : row) {
                if (value < min) {
                    min = value;
                }
            }
            sumOfMin += min;
        }
        System.out.println("Sum of the minimal numbers in matrix rows: " + sumOfMin);

    }

    // Заповнює матрицю випадковими числами
    private static void randomizeMatrix(short[][] matrix) {
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (short) random.nextInt(Short.MAX_VALUE + 1);
            }
        }
    }

    // Виводить матрицю в консоль
    private static void printMatrix(short[][] matrix) {
        for (short[] row : matrix) {
            for (short value : row) {
                System.out.printf("%5d\t", value);
            }
            System.out.println();
        }
    }
}