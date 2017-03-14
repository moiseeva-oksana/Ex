package heap;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> {
    private List<T> array;
    private int size;


    public BinaryHeap() {
        array = new ArrayList<>();
        size = 0;
    }

    public void insert(T value) {
        size++;
        int index = size - 1;
        array.add(index, value);
        bubbleUp();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return array.get(0);
    }

    public T remove() {
        T result = peek();
        array.set(0, array.get(size-1));
        array.remove(size-1);
        size--;
        bubbleDown();
        return result;
    }

    private void bubbleDown() {
        int index = 0;
        while (hasRightChild(index)) {
            int biggerChild = rightIndex(index);
            if (hasLeftChild(index)
                    && array.get(rightIndex(index)).compareTo(array.get(leftIndex(index))) < 0) {
                biggerChild = leftIndex(index);
            }
            if (array.get(index).compareTo(array.get(biggerChild)) < 0) {
                swap(index, biggerChild);
            } else {
                break;
            }
            index = biggerChild;
        }
    }


    private void bubbleUp() {
        int index = this.size - 1;
        while (hasParent(index + 1)
                && (parent(index).compareTo(array.get(index)) < 0)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }

    }

    private boolean hasParent(int i) {
        return i > 1;
    }

    private int leftIndex(int i) {
        return i * 2;
    }


    private int rightIndex(int i) {
        return i * 2 + 1;
    }


    private boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }


    private boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }


    private T parent(int i) {
        return array.get(parentIndex(i));
    }


    private int parentIndex(int i) {
        return i / 2;
    }

    private void swap(int index1, int index2) {
        T tmp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, tmp);
    }


    public static void main(String[] args) {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>();
        binaryHeap.insert(15);
        binaryHeap.insert(1);
        binaryHeap.insert(6);
        binaryHeap.array.forEach(System.out::print);
        System.out.println("");
        binaryHeap.insert(12);
        binaryHeap.insert(8);
        binaryHeap.array.forEach(System.out::print);
        System.out.println("");
        binaryHeap.insert(20);
        binaryHeap.insert(17);
        binaryHeap.array.forEach(System.out::println);
        System.out.println("");
        binaryHeap.insert(13);
        binaryHeap.insert(16);

        binaryHeap.array.forEach(System.out::println);
        System.out.println("");
        binaryHeap.remove();
        binaryHeap.array.forEach(System.out::println);
        System.out.println("");

    }
}