package sorting;

import java.util.Scanner;

// задача 2: команды ADD, CONTAINS, REMOVE, COUNT_RANGE и PRINT для массива заявок
public class Task2Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedArray array = new SortedArray();

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        // исходные номера кладём через add, они сами встанут по порядку
        for (int i = 0; i < n; i++) {
            array.add(scanner.nextInt());
        }

        // по примеру из условия сначала выводим отсортированный исходный массив
        System.out.println(array.print());

        for (int i = 0; i < q; i++) {
            String command = scanner.next();

            if (command.equals("ADD")) {
                array.add(scanner.nextInt());
            } else if (command.equals("CONTAINS")) {
                if (array.contains(scanner.nextInt())) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if (command.equals("REMOVE")) {
                array.remove(scanner.nextInt());
            } else if (command.equals("COUNT_RANGE")) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                System.out.println(array.countRange(l, r));
            } else if (command.equals("PRINT")) {
                System.out.println(array.print());
            }
        }
    }
}
