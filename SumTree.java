public class SumTree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Utility function to find the sum
    static int findSum(Node root) {
        if (root == null) {
            return 0;
        }

        return root.data + findSum(root.left) + findSum(root.right);
    }

    boolean isSumTree(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null || root.right != null) {
            if (root.data != findSum(root.left) + findSum(root.right)) {
                return false;
            }
        }

        return isSumTree(root.left) && isSumTree(root.right);
    }
}
