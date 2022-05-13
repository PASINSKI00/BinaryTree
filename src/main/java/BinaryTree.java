import static java.lang.Math.max;

public class BinaryTree {
    private final Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int rootValue) {
        root = new Node(rootValue);
    }

    public int getNumberOfLeafs() {
        return getNumberOfLeafs(this.root);
    }

    public int getNumberOfLeafs(Node root) {
        if (root == null)
            return 0;

        if (root.getLeft() == null && root.getRight() == null)
            return 1;

        int left = getNumberOfLeafs(root.getLeft());
        int right = getNumberOfLeafs(root.getRight());

        return left + right;
    }

    public int getLargestNumberOfEdges() {
        if (this.root == null)
            return 0;

        return getLargestNumberOfEdges(this.root);
    }

    public boolean areEqual(Node other) {
        return areEqual(this.root, other);
    }

    public boolean areEqual(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return true;

        if(root1 != null && root2 != null)
            return root1.getValue() == root2.getValue() && areEqual(root1.getLeft(), root2.getLeft()) && areEqual(root1.getRight(), root2.getRight());

        return false;
    }

    public Node getRoot() {
        return root;
    }

    private int getLargestNumberOfEdges(Node root) {
        if (root == null)
            return -1;

        int left = getLargestNumberOfEdges(root.getLeft());
        int right = getLargestNumberOfEdges(root.getRight());

        return max(left, right) +1;
    }
}
