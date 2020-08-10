import java.util.Scanner;

public class RunningMedian {

    private int[] heap;
    private int size;

    public RunningMedian(int n) {
        heap = new int[n];
        size = 0;
    }

    public int parent(int pos) {
        return (pos - 1) / 2;
    }

    public void swap(int x, int y) {
        int tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }

    public void add(int value) {
        heap[size++] = value;
        sort();
        median();
    }

    private void median() {
        int middle = size / 2;
        double value = 0.0;

        if (size == 1) value = (double) heap[0];
        else if (size % 2 == 0) value = (double) (heap[middle - 1] + heap[middle]) / 2;
        else value = (double) heap[middle];

        System.out.printf("%.2f\n", value);
    }

    private void sort() {
        int last = parent(size - 1);
        while (last >= 0) {
            heapify(size, last);
            last--;
        }

        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            heapify(i, 0);
        }
    }

    private void heapify(int n, int pos) {
        int max = pos;
        int left = (2 * pos) + 1;
        int right = (2 * pos) + 2;

        if (left < n && heap[pos] < heap[left]) {
            max = left;
        }
        if (right < n && heap[right] > heap[max]) {
            max = right;
        }
        if (max != pos) {
            swap(pos, max);
            heapify(n, max);
        }

    }
}

class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        RunningMedian heap = new RunningMedian(n);

        in.nextLine();
        while (n-- > 0) {
            heap.add(in.nextInt());
        }
    }
}