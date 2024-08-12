public class RotateList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            
        }
    }

    static Node rotate(Node head, int k) {
        Node tempNode = head;

        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }

        tempNode.next = head;

        while (k > 1) {
            head = head.next;
            k--;
        }
        Node newHead = head.next;
        head.next = null;
        return newHead;
    }

}
