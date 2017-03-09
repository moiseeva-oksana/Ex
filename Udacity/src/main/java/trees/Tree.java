package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree<T> {
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    private void traverseBreadthFirst(Node<T> node) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node<T> n = queue.remove();
            visit(n);
            for (Node<T> child : n.children) {
                if (child != null)
                    queue.add(child);
            }
        }
    }

    private void traversePreOrder(Node<T> node) {
        visit(node);
        for (Node<T> child : node.children) {
            traversePreOrder(child);
        }
    }
    private void traversePostOrder(Node<T> node) {
        for (Node<T> child : node.children) {
            traversePostOrder(child);
        }
        visit(node);
    }


    private void traverseInOrder(Node<T> node) {
        if (node.children.isEmpty()) {
            visit(node);
            return;
        }
        traverseInOrder(node.children.get(0));
        visit(node);
        if (node.children.size() > 1) {
            for(int i=1;i<node.children.size();i++) {
                traverseInOrder(node.children.get(i));
            }
        }
    }

    private void visit(Node<T> node) {
        System.out.println(node.entity);
    }




    private static class Node<T> {
        private T entity;
        private Node<T> parent;
        private List<Node<T>> children = new LinkedList<>();
        private int size;

        public Node(T entity) {
            this.entity = entity;
        }
        private void addChild(T element) {
            size++;
            Node<T> node = new Node<>(element);
            node.parent = this;
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
//         root.children.get(1).addChild("Six");

        Tree<String> tree = new Tree<>(root);
        System.out.println("Pre _______________");
        tree.traversePreOrder(tree.root);

        System.out.println("Post _______________");
        tree.traversePostOrder(tree.root);

        System.out.println("In _______________");
        tree.traverseInOrder(tree.root);

        System.out.println("Breadth _______________");
        tree.traverseBreadthFirst(tree.root);



    }
}
