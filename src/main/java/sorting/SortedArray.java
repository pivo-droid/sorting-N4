package sorting;

// отсортированный массив с уникальными номерами заявок
public class SortedArray {

    private int[] data = new int[10];
    private int size = 0;

    // индекс первого элемента, который >= x (если таких нет, то size)
    private int lowerBound(int x) {
        int left = 0;
        int right = size;

        while (left < right) {
            int middle = (left + right) / 2;
            if (data[middle] >= x) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    // добавляет x на своё место, повторы не добавляем
    public void add(int x) {
        int pos = lowerBound(x);
        if (pos < size && data[pos] == x) {
            return;
        }

        // если места нет, делаем массив в два раза больше
        if (size == data.length) {
            int[] bigger = new int[size * 2];
            for (int i = 0; i < size; i++) {
                bigger[i] = data[i];
            }
            data = bigger;
        }

        // сдвигаем всё что правее на одну клетку вправо
        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = x;
        size++;
    }

    public boolean contains(int x) {
        int pos = lowerBound(x);
        return pos < size && data[pos] == x;
    }

    // удаляет x, если он есть
    public void remove(int x) {
        int pos = lowerBound(x);
        if (pos == size || data[pos] != x) {
            return;
        }

        // сдвигаем всё что правее на одну клетку влево
        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    // сколько номеров лежит от l до r включительно
    public int countRange(int l, int r) {
        if (l > r) {
            return 0;
        }
        // позиция сразу после r: если r есть в массиве, то это на одну клетку правее
        int end = lowerBound(r);
        if (end < size && data[end] == r) {
            end++;
        }
        return end - lowerBound(l);
    }

    // весь массив одной строкой через пробел
    public String print() {
        String result = "";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result += " ";
            }
            result += data[i];
        }
        return result;
    }
}
