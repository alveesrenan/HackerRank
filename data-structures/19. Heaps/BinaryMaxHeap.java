import java.util.Scanner;
import java.util.stream.IntStream;

public class BinaryMaxHeap {
    int[] heap;
    int size;

    public BinaryMaxHeap(int n) {
        this.heap = new int[n];
        this.size = 0;
    }

    public int parent(int pos) {
        return (pos - 1) / 2;
    }

    public int left(int pos) {
        return (2 * pos) + 1;
    }

    public int right(int pos) {
        return (2 * pos) + 2;
    }

    public void swap(int x, int y) {
        int tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }

    public void add(int value) {
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public void remove() {
        int max = heap[0], n = --size;
        heap[0] = heap[heap.length - 1];
        heapifyDown(n, 0);
        System.out.println("MAX VALUE ON HEAP: " + max);
    }

    public void heapifyUp(int pos) {
        int current = pos;
        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void heapifyDown(int n, int pos) {
        int max = pos;
        if (left(pos) < n && heap[pos] < heap[left(pos)]) {
            max = left(pos);
        }
        if (right(pos) < n && heap[right(pos)] > heap[max]) {
            max = right(pos);
        }
        if (max != pos) {
            swap(pos, max);
            heapifyDown(n, max);
        }
    }

    public void print() {
        IntStream.range(0, size).forEach(index -> System.out.printf("%d ", heap[index]));
        System.out.println();
    }
}

class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        BinaryMaxHeap heap = new BinaryMaxHeap(n);

        in.nextLine();
        while (n-- > 0) {
            heap.add(in.nextInt());
        }
        heap.print();
        heap.remove();
        heap.print();
    }
}
