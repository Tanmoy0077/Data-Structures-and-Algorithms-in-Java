package DSA;

// * Node Structure for the LinkedList

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {

    Node head; // Head of the linked list

    MyLinkedList() {
        this.head = null;
    }

    // Add element at the end
    void addEnd(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node(data);
        }
    }

    // Add element at the begining
    void addBegin(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Delete from the end
    void delEnd() {
        if (head == null) {
            System.out.println("List Empty");
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head, prev = head;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }
    }

    // Delete from the begining
    void delBegin() {
        if (head == null) {
            System.out.println("List Empty");
        } else if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
    }

    // Reverse the linked list
    void reverse() {
        if (head == null) {
            System.out.println("List Empty");
        } else {
            Node prev = head, curr = head.next, next;
            prev.next = null; // Set end of the linked list
            while (curr != null) {
                next = curr.next; // Get hold of the next node
                curr.next = prev; // Make the current node point towards previous
                prev = curr; // Move the previous node
                curr = next; // Move the current node
            }
            head = prev; // Set the head pointer towards the previous item
        }
    }

    // Helper function for reversing using recursion
    void reverseRecusion() {
        if (head == null) {
            System.out.println("List Empty");
        } else {
            Node curr = head.next;
            head.next = null;
            switchLink(head, curr);
        }
    }

    // Recursive function for reversing the linked list
    private void switchLink(Node prev, Node curr) {
        if (curr == null) {
            head = prev;
            return;
        }
        Node next = curr.next;
        curr.next = prev;
        switchLink(curr, next);
    }

    // Display the linked list
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node temp = head;
        while (temp != null) {
            result.append(temp.data + ", ");
            temp = temp.next;
        }
        result.append("]");
        return result.toString();
    }

    // Sorted insert
    void sortedInsert(int data) {
        Node curr = head, prev = head;
        while (curr != null) {
            if (data < curr.data)
                break;
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            addEnd(data);
        } else if (curr == head) {
            addBegin(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = curr;
            prev.next = newNode;
        }
    }

    // Insert at the middle
    void insertMiddle(int data) {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) { // For even elements fast is null otherwise fast.next is null
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newNode = new Node(data);
        newNode.next = slow.next;
        slow.next = newNode;
    }

}

public class SinglyLinkedList {
    // Adds the 2nd linked list at end of the 1st linked list
    public static void joinLinkedList(MyLinkedList l1, MyLinkedList l2) {
        Node curr = l1.head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = l2.head;
    }

    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.sortedInsert(50);
        l.sortedInsert(10);
        l.sortedInsert(20);
        l.sortedInsert(30);
        l.sortedInsert(60);
        l.insertMiddle(40);
        MyLinkedList t = new MyLinkedList();
        t.addEnd(70);
        t.addEnd(80);
        joinLinkedList(l, t);
        System.out.println(l);
    }

}
