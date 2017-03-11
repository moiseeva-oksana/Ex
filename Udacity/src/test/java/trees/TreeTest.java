package trees;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {
    private Tree tree;
    @Before
    public void init() {
        tree=new Tree();
        tree.add(5);
        tree.add(4);
        tree.add(7);
        tree.add(8);
        tree.add(3);
        tree.add(2);
        tree.add(6);
    }

    @Test
    public void addTest() throws Exception {
        assertThat(tree.getSize(), is(7));
        tree.add(10);
        assertThat(tree.getSize(), is(8));
        assertThat(tree.find(10).getParent(), is(tree.find(8)));
    }

    @Test
    public void findTest() throws Exception {
        Tree.Node node = tree.find(4);
        assertThat(node.getEntity(), is(4));
        Tree.Node node2 = tree.find(55);
        assertThat(node2==null, is(true));
    }

    @Test
    public void rankTest() throws Exception {
        assertThat(tree.rank(tree.getRoot()), is(6));
        tree.add(10);
        assertThat(tree.rank(tree.getRoot()), is(7));

    }

    @Test
    public void depthTest() throws Exception {
        assertThat(tree.depth(tree.getRoot()), is(0));
        assertThat(tree.depth(tree.find(8)), is(2));
    }

    @Test
    public void heightTest() throws Exception {
        assertThat(tree.height(tree.getRoot()), is(3));
        assertThat(tree.height(tree.find(8)), is(0));
        assertThat(tree.height(tree.find(4)), is(2));
        tree.add(9);
        assertThat(tree.height(tree.getRoot()), is(3));
        tree.add(0);
        assertThat(tree.height(tree.getRoot()), is(4));
    }
    @Test
    public void traverseTest() {
        System.out.println("Preorder:");
        tree.traversePreOrder(tree.getRoot());
        System.out.println("Postorder:");
        tree.traversePostOrder(tree.getRoot());
        System.out.println("Inorder:");
        tree.traverseInOrder(tree.getRoot());
        System.out.println("BFS:");
        tree.traverseBreadthFirst();
    }

}