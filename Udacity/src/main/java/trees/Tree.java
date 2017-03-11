package trees;

/**
 * Binary Search Tree
 */

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private Node root;
    private int size;

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public void traverseBreadthFirst() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            visit(n);
            if (n.left != null)
                queue.add(n.left);
            if (n.right != null)
                queue.add(n.right);

        }
    }

    public void traversePreOrder(Node node) {
        visit(node);
        if (node.left != null)
            traversePreOrder(node.left);
        if (node.right != null)
            traversePreOrder(node.right);

    }

    public void traversePostOrder(Node node) {
        if (node.left != null)
            traversePostOrder(node.left);
        if (node.right != null)
            traversePostOrder(node.right);
        visit(node);
    }


    public void traverseInOrder(Node node) {
        if (node.left != null)
            traverseInOrder(node.left);
        visit(node);
        if (node.right != null)
            traverseInOrder(node.right);

    }

    private void visit(Node node) {
        System.out.println(node.entity);
    }


    public boolean add(int element) {
        boolean result;
        if (root == null) {
            root = new Node(element);
            result = true;
        } else {
            result = root.addChild(element);
        }
        if (result) {
            size++;
        }
        return result;
    }

    public Node find(int element) {
        return root.findElement(element);
    }

    public int rank(Node node) {
        return node.rank();
    }

    public int depth(Node node) {
        int result = 0;
        if (node == root) {
            return result;
        }
        Node parent = node.parent;
        while (parent != null) {
            parent = parent.parent;
            result++;
        }
        return result;
    }

    public int height(Node node) {
        return node.height();
    }

    static class Node {
        private int entity;
        private Node left;
        private Node right;
        private Node parent;

        public int getEntity() {
            return entity;
        }

        public Node getParent() {
            return parent;
        }

        private Node(int entity) {
            this.entity = entity;
        }


        private boolean addChild(int element) {
            if (element == entity)
                return false;
            if (element < entity) {
                if (left == null) {
                    left = new Node(element);
                    left.parent = this;
                    return true;
                } else
                    return left.addChild(element);
            }
            if (element > entity) {
                if (right == null) {
                    right = new Node(element);
                    right.parent = this;
                    return true;
                } else
                    return right.addChild(element);
            }
            return false;
        }

        private Node findElement(int element) {
            if (element == entity)
                return this;
            if (element < entity) {
                if (left == null) {
                    return null;
                } else
                    return left.findElement(element);
            }
            if (element > entity) {
                if (right == null) {
                    return null;
                } else
                    return right.findElement(element);
            }
            return null;
        }

        private int rank() {
            int count = 0;
            if (left != null) {
                count++;
            }
            if (right != null) {
                count++;
            }
            return count + ((left != null) ? left.rank() : 0) + ((right != null) ? right.rank() : 0);
        }

        private int height() {
            if (left == null && right == null) {
                return 0;
            }

            int lefty = ((left != null) ? left.height() : 0);
            int righty = ((right != null) ? right.height() : 0);

            if (lefty > righty) {
                return lefty + 1;
            } else {
                return righty + 1;
            }

        }
    }
}
