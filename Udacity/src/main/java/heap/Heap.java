package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {
    private List<T> array = new ArrayList<>();
    private int size = 0;

    public List<T> getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public void insert(T value) {
        int index = size;
        size++;
        array.add(index, value);
        floatUp();
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
        array.set(0, array.get(size - 1));
        array.remove(size - 1);
        size--;
        sink();
        return result;
    }

    private void sink() {
        int index = 0;
        while (hasRightChild(index + 1)) {
            int biggerChild = rightIndex(index);
            if (hasLeftChild(index + 1)
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

    private void floatUp() {
        int index = this.size - 1;
        while (hasParent(index + 1) && (parent(index).compareTo(array.get(index)) < 0)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }
    private void swap(int index1, int index2) {
        T tmp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, tmp);
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

    T parent(int i) {
        return array.get(parentIndex(i));
    }

    private int parentIndex(int i) {
        return i / 2;
    }

}