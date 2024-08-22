public class BurningTree {
    public static int burnTree(Node root, Map<Node, Node> nodeToParent) {
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        visited.put(root, true);
        
        int ans = 0;
        
        while (!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                
                if (current.left != null && !visited.getOrDefault(current.left, false)) {
                    flag = true;
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                
                if (current.right != null && !visited.getOrDefault(current.right, false)) {
                    flag = true;
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                
                Node parent = nodeToParent.get(current);
                if (parent != null && !visited.getOrDefault(parent, false)) {
                    flag = true;
                    queue.offer(parent);
                    visited.put(parent, true);
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }

    public static Node createParentMapping(Node root, int target, Map<Node, Node> nodeToParent) {
        Node result = null;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        nodeToParent.put(root, null);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.data == target) {
                result = current;
            }
            
            if (current.left != null) {
                nodeToParent.put(current.left, current);
                queue.offer(current.left);
            }
            
            if (current.right != null) {
                nodeToParent.put(current.right, current);
                queue.offer(current.right);
            }
        }
        return result;
    }

    public static int minTime(Node root, int target) {
        Map<Node, Node> nodeToParent = new HashMap<>();
        Node targetNode = createParentMapping(root, target, nodeToParent);
        
        int ans = burnTree(targetNode, nodeToParent);
        
        return ans;
    }
}
