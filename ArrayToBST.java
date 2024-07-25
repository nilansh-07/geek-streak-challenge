public class ArrayToBST {

    public static class Node {
        int data;
        Node left, right;

        // Constructor to initialize a new node
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Recursive method to construct a balanced BST from a sorted array
    public static Node constructBST(int[] nums, int left, int right) {
        // Base case when no elements are left to process
        if (left > right) {
            return null;
        }

        // Calculate the middle index for root node
        int mid = left + (right - left) / 2;
        // Create a new node with the middle element
        Node newNode = new Node(nums[mid]);

        // Recursively construct the left and right subtrees
        newNode.left = constructBST(nums, left, mid - 1);
        newNode.right = constructBST(nums, mid + 1, right);

        return newNode;
    }

    // Wrapper method to initiate BST construction from sorted array
    public static Node sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    // Utility method to print the tree in-order to ensure it is a BST
    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

        // Convert the sorted array to a BST
        Node root = sortedArrayToBST(nums);

        // Print the in-order traversal of the constructed BST
        System.out.println("In-order traversal of the constructed BST:");
        inOrderTraversal(root);
    }
}
