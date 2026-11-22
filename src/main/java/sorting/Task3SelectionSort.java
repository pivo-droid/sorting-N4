package sorting;

import java.util.Scanner;

// задача 3: сортировка выбором, считаем сравнения и обмены
public class Task3SelectionSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            // ищем самый маленький элемент среди тех, что правее i (и сам i)
            int min = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            // если минимум не на своём месте, меняем местами
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
                swaps++;
            }
        }

        // выводим массив, потом количество сравнений и обменов
        String result = "";
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                result += " ";
            }
            result += array[i];
        }
        System.out.println(result);
        System.out.println(comparisons);
        System.out.println(swaps);
    }
}
