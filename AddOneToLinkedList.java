public class AddOneToLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node reverseList(Node head) {
        Node prev = null, nextNode = null, currentNode = head;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
        }

        return prev;
    }

    static Node addOne(Node head) {
        head = reverseList(head);
        int carry = 1;
        Node tempNode = head;
        // Tail node, if all the nodes would be 9 then at the end creates node and
        // assign 1
        Node tailNode = null;

        while (tempNode != null && carry != 0) {
            if (tempNode.data == 9) {
                tempNode.data = 0;
            } else {
                tempNode.data = tempNode.data + 1;
                carry = 0;
            }
            tailNode = tempNode;
            tempNode = tempNode.next;
        }
        // If carry is still there means list was full of 9s
        if (carry != 0) {
            tailNode.next = new Node(1);
        }
        head = reverseList(head);

        return head;
    }

}
