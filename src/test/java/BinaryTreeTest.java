import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void getNumberOfLeafs_ShouldReturn6() {
        //given
        BinaryTree tree = new BinaryTree(5);

        tree.getRoot().setLeft(new Node(3));
        tree.getRoot().setRight(new Node(7));

        tree.getRoot().getLeft().setLeft(new Node(2));
        tree.getRoot().getLeft().setRight(new Node(5));

        tree.getRoot().getRight().setLeft(new Node(1));
        tree.getRoot().getRight().setRight(new Node(0));

        tree.getRoot().getRight().getRight().setLeft(new Node(2));
        tree.getRoot().getRight().getRight().setRight(new Node(8));

        tree.getRoot().getRight().getRight().getRight().setRight(new Node(5));
        tree.getRoot().getRight().getRight().getRight().setLeft(new Node(5));
        int expected = 6;

        //when
        int actual = tree.getNumberOfLeafs();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void getNumberOfLeafs_ShouldReturn1() {
        //given
        BinaryTree tree = new BinaryTree(5);
        int expected = 1;

        //when
        int actual = tree.getNumberOfLeafs();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void getNumberOfLeafs_ShouldReturnCorrect_WhenRootIsNull() {
        //given
        BinaryTree tree = new BinaryTree();
        int expected = 0;

        //when
        int actual = tree.getNumberOfLeafs();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void getNumberOfLeafs_ShouldReturnCorrectValue_WhenOnlyRoot() {
        //given
        BinaryTree tree = new BinaryTree(1);
        int expected = 1;

        //when
        int actual = tree.getNumberOfLeafs();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void getLargestNumberOfEdges_ShouldReturn4() {
        //given
        BinaryTree tree = new BinaryTree(5);
        tree.getRoot().setLeft(new Node(3));
        tree.getRoot().setRight(new Node(7));
        tree.getRoot().getLeft().setLeft(new Node(2));
        tree.getRoot().getLeft().setRight(new Node(5));
        tree.getRoot().getRight().setLeft(new Node(1));
        tree.getRoot().getRight().setRight(new Node(0));
        tree.getRoot().getRight().getRight().setLeft(new Node(2));
        tree.getRoot().getRight().getRight().setRight(new Node(8));
        tree.getRoot().getRight().getRight().getRight().setRight(new Node(5));
        int expected = 4;

        //when
        int actual = tree.getLargestNumberOfEdges();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void getLargestNumberOfEdges_ShouldReturnCorrectValue_WhenRootIsNull() {
        //given
        BinaryTree tree = new BinaryTree();
        int expected = 0;

        //when
        int actual = tree.getLargestNumberOfEdges();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void getLargestNumberOfEdges_ShouldReturnCorrectValue_WhenOnlyRoot() {
        //given
        BinaryTree tree = new BinaryTree(1);
        int expected = 0;

        //when
        int actual = tree.getLargestNumberOfEdges();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void areEqual_ShouldReturnTrue() {
        //given
        BinaryTree tree = new BinaryTree(5);
        tree.getRoot().setLeft(new Node(3));
        tree.getRoot().setRight(new Node(7));
        tree.getRoot().getLeft().setLeft(new Node(2));
        tree.getRoot().getLeft().setRight(new Node(5));
        tree.getRoot().getRight().setLeft(new Node(1));
        tree.getRoot().getRight().setRight(new Node(0));
        tree.getRoot().getRight().getRight().setLeft(new Node(2));
        tree.getRoot().getRight().getRight().setRight(new Node(8));
        tree.getRoot().getRight().getRight().getRight().setRight(new Node(5));

        BinaryTree tree2 = new BinaryTree(5);
        tree2.getRoot().setLeft(new Node(3));
        tree2.getRoot().setRight(new Node(7));
        tree2.getRoot().getLeft().setLeft(new Node(2));
        tree2.getRoot().getLeft().setRight(new Node(5));
        tree2.getRoot().getRight().setLeft(new Node(1));
        tree2.getRoot().getRight().setRight(new Node(0));
        tree2.getRoot().getRight().getRight().setLeft(new Node(2));
        tree2.getRoot().getRight().getRight().setRight(new Node(8));
        tree2.getRoot().getRight().getRight().getRight().setRight(new Node(5));

        //when
        boolean actual = tree.areEqual(tree2.getRoot());

        //then
        assertTrue(actual);
    }

    @Test
    void areEqual_ShouldReturnFalse() {
        //given
        BinaryTree tree = new BinaryTree(5);
        tree.getRoot().setLeft(new Node(3));
        tree.getRoot().setRight(new Node(7));
        tree.getRoot().getLeft().setLeft(new Node(2));
        tree.getRoot().getLeft().setRight(new Node(5));
        tree.getRoot().getRight().setLeft(new Node(1));
        tree.getRoot().getRight().setRight(new Node(0));
        tree.getRoot().getRight().getRight().setLeft(new Node(2));
        tree.getRoot().getRight().getRight().setRight(new Node(8));
        tree.getRoot().getRight().getRight().getRight().setRight(new Node(5));

        BinaryTree tree2 = new BinaryTree(5);
        tree2.getRoot().setLeft(new Node(3));
        tree2.getRoot().setRight(new Node(7));
        tree2.getRoot().getLeft().setLeft(new Node(2));
        tree2.getRoot().getLeft().setRight(new Node(5));
        tree2.getRoot().getRight().setLeft(new Node(1));
        tree2.getRoot().getRight().setRight(new Node(0));
        tree2.getRoot().getRight().getRight().setLeft(new Node(2));
        tree2.getRoot().getRight().getRight().setRight(new Node(8));
        tree2.getRoot().getRight().getRight().getRight().setRight(new Node(5));
        tree2.getRoot().getRight().getRight().getRight().setLeft(new Node(5));

        //when
        boolean actual = tree.areEqual(tree2.getRoot());

        //then
        assertFalse(actual);
    }

    @Test
    void areEqual_ShouldReturnFalse_WhenComparingWithNull() {
        //given
        BinaryTree tree = new BinaryTree(5);

        //when
        boolean actual = tree.areEqual(null);

        //then
        assertFalse(actual);
    }

    @Test
    void areEqual_ShouldReturnFalse_WhenIsNullAndComparesWithNode() {
        //given
        BinaryTree tree = new BinaryTree();
        BinaryTree tree2 = new BinaryTree(5);

        //when
        boolean actual = tree.areEqual(tree2.getRoot());

        //then
        assertFalse(actual);
    }

    @Test
    void areEqual_ShouldReturnTrue_WhenComparingTwoNulls() {
        //given
        BinaryTree tree = new BinaryTree();

        //when
        boolean actual = tree.areEqual(null);

        //then
        assertTrue(actual);
    }
}