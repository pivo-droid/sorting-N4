package sorting;

import java.util.Scanner;

// задача 4: оценки поступают по одной, список всегда отсортирован
public class Task4Grades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] list = new int[n];
        int size = 0;

        for (int k = 0; k < n; k++) {
            int grade = scanner.nextInt();

            // идём с конца и сдвигаем вправо всё, что больше новой оценки
            int j = size - 1;
            while (j >= 0 && list[j] > grade) {
                list[j + 1] = list[j];
                j--;
            }
            // на освободившееся место ставим новую оценку
            list[j + 1] = grade;
            size++;

            // выводим список после каждого добавления
            String result = "";
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    result += " ";
                }
                result += list[i];
            }
            System.out.println(result);
        }
    }
}
