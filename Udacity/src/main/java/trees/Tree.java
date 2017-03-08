package trees;

import java.util.LinkedList;
import java.util.List;

public class Tree<T> {
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public List<T> traversePreOrder(List<T> list) {
        return root.traversePreOrder(list);
    }

    public List<T> traversePostOrder(List<T> list) {
        return root.traversePostOrder(list);
    }

    public List<T> traverseInOrder(List<T> list) {
        return root.traverseInOrder(list);
    }

    private static class Node<T> {
        private T entity;
        private Node<T> parent;
        private List<Node<T>> children=new LinkedList<>();

        public Node(T entity) {
            this.entity = entity;
        }

        private T visit() {
            return this.entity;
        }

        private List<T> traversePreOrder(List<T> result) {
            result.add(visit());
            for(Node<T> child: children) {
                child.traversePreOrder(result);
            }
            return result;
        }

        private List<T> traversePostOrder(List<T> result) {
            for(Node<T> child: children) {
                child.traversePostOrder(result);
            }
            result.add(visit());
            return result;
        }
        private List<T> traverseInOrder(List<T> result) {
            if(children.isEmpty()) {
                result.add(visit());
                return result;
            }

            children.get(0).traverseInOrder(result);
            result.add(visit());
            if(children.size()>1) {
                children.get(1).traverseInOrder(result);
            }
            return result;
        }

        private void addChild(T element) {
            Node<T> node = new Node<>(element);
            node.parent=this;
            children.add(node);
        }

    }

    public static void main(String[] args) {
        Node<String> root = new Node<>("Root");
        root.addChild("One");
        root.addChild("Two");
        root.children.get(0).addChild("Three");
        root.children.get(0).addChild("Four");
        root.children.get(1).addChild("Five");
       // root.children.get(1).addChild("Six");

        Tree<String> tree = new Tree<>(root);
        List<String> traverse = new LinkedList<>();
        tree.traversePreOrder(traverse);
        System.out.println("Pre "+ traverse);
        traverse = new LinkedList<>();
        tree.traversePostOrder(traverse);
        System.out.println("Post "+traverse);
        traverse = new LinkedList<>();
        tree.traverseInOrder(traverse);
        System.out.println("In "+traverse);
    }
}
