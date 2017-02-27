package queueAndStack;

import java.util.Deque;
import java.util.LinkedList;

public class QueueThroughStacks<T> {
    private Deque<T> firstStack = new LinkedList<>();
    private Deque<T> secondStack = new LinkedList<>();

    public void push(T element) {
        firstStack.addLast(element);
    }

    public T pop() {
        int size = firstStack.size();
        for(int i=0; i<size; i++) {
            secondStack.addLast(firstStack.removeLast());
        }
        return secondStack.removeLast();
    }

}
