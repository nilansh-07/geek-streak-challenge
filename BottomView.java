import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        root.hd = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int hd = currentNode.hd;

            map.put(hd, currentNode.data);
            if (currentNode.left != null) {
                currentNode.left.hd = hd - 1;
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                currentNode.right.hd = hd + 1;
                queue.offer(currentNode.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
