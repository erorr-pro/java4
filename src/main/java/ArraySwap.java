import java.util.Arrays;

public class ArraySwap {

    /**
     * Логика программы и важные переменные.
     */
    public static void main(String[] args) {
        int a = -10; // Начальное значение диапазона
        int b = 10; // Конечное значение диапазона
        int arrayDimension = 20; // Размерность массива

        int[] lineMatrix = createLineMatrix(a, b, arrayDimension);
        int maximumNegativeNum = maximumNegativeNumMatrix(lineMatrix);
        int minimumPositiveNum = minimumPositiveNumMatrix(lineMatrix);
        swapNumbers(lineMatrix, maximumNegativeNum, minimumPositiveNum, arrayDimension);
    }

    /**
     * Функция генерирует массив lineMatrix заданного размера.
     *
     * @param a              Начальное значение диапазона чисел.
     * @param b              Конечное значение диапазона чисел.
     * @param arrayDimension Размерность массива.
     * @return Возвращает массив lineMatrix.
     */
    public static int[] createLineMatrix(int a, int b, int arrayDimension) {
        int[] lineMatrix = new int[arrayDimension]; // задаём размерность массива
        for (int increment = 0; increment < arrayDimension; increment++) {
            lineMatrix[increment] = a + (int) (Math.random() * ((b - a) + 1)); // видя это тихо плачет питонист
        }
        System.out.println("Массив: " + Arrays.toString(lineMatrix));
        return lineMatrix;
    }

    /**
     * Функция ищет максимальное отрицательное число в массиве lineMatrix.
     *
     * @param lineMatrix Массив рандомных чисел.
     * @return Максимальное отрицательное число в массиве lineMatrix.
     */
    public static int maximumNegativeNumMatrix(int[] lineMatrix) {  // максимальное отрицательное
        int maximumNegativeNum = 0;
        for (int matrix : lineMatrix) {
            if (matrix < 0) {
                if (maximumNegativeNum == 0 || matrix > maximumNegativeNum)
                    maximumNegativeNum = matrix;
            }
        }
        System.out.println("Максимальное отрицательное число в массиве: " + maximumNegativeNum);
        return maximumNegativeNum;
    }

    /**
     * Функция ищет минимальное положительное число в массиве lineMatrix.
     *
     * @param lineMatrix Массив рандомных чисел.
     * @return Минимальное положительное число в массиве lineMatrix.
     */
    public static int minimumPositiveNumMatrix(int[] lineMatrix) { // минимальное положительное
        int minimumPositiveNum = 0;
        for (int matrix : lineMatrix) {
            if (matrix > 0) {
                if (minimumPositiveNum == 0 || matrix < minimumPositiveNum)
                    minimumPositiveNum = matrix;
            }
        }
        System.out.println("Минимальное положительное число в массиве: " + minimumPositiveNum);
        return minimumPositiveNum;
    }

    /**
     * Функция осуществляет подмену maximumNegativeNum и minimumPositiveNum в массиве lineMatrix.
     *
     * @param lineMatrix         Массив рандомных чисел.
     * @param maximumNegativeNum Минимальное число в массиве lineMatrix.
     * @param minimumPositiveNum Максимальное число в массиве lineMatrix.
     * @param arrayDimension     Размерность массива.
     */
    public static void swapNumbers(int[] lineMatrix, int maximumNegativeNum, int minimumPositiveNum, int arrayDimension) {
        int[] swapLineMatrix = new int[arrayDimension]; // обновлённый массив
        for (int increment = 0; increment < arrayDimension; increment++) {
            if (lineMatrix[increment] == maximumNegativeNum) {
                swapLineMatrix[increment] = minimumPositiveNum;
            } else if (lineMatrix[increment] == minimumPositiveNum) {
                swapLineMatrix[increment] = maximumNegativeNum;
            } else if (lineMatrix[increment] != minimumPositiveNum & lineMatrix[increment] != maximumNegativeNum) {
                swapLineMatrix[increment] = lineMatrix[increment];
            } else {
                System.out.println("Не предвиденная ошибка!");
            }
        }
        System.out.println("Обновлённый массив: " + Arrays.toString(swapLineMatrix));

    }


}
