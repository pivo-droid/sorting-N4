package sorting;

import java.util.Scanner;

// задача 1: первый элемент отсортированного массива, который не меньше x
public class Task1LowerBound {

    // бинарный поиск: возвращает первый элемент, который >= x, или -1, если такого нет
    static int findFirst(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        int answer = -1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] >= x) {
                // этот элемент подходит, запоминаем и ищем подходящий левее
                answer = array[middle];
                right = middle - 1;
            } else {
                // этот элемент слишком маленький, ищем правее
                left = middle + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // на каждый запрос выводим один ответ
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            System.out.println(findFirst(array, x));
        }
    }
}
