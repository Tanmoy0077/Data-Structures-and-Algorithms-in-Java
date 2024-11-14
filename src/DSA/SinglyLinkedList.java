package DSA;

// * LinkedNode Structure for the LinkedList

class LinkedNode {
    int data;
    LinkedNode next;

    LinkedNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {

    LinkedNode head; // Head of the linked list

    MyLinkedList() {
        this.head = null;
    }

    // Add element at the end
    void addEnd(int data) {
        if (head == null) {
            head = new LinkedNode(data);
        } else {
            LinkedNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new LinkedNode(data);
        }
    }

    // Add element at the begining
    void addBegin(int data) {
        LinkedNode newNode = new LinkedNode(data);
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
            LinkedNode temp = head, prev = head;
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
            LinkedNode prev = head, curr = head.next, next;
            prev.next = null; // Set end of the linked list
            while (curr != null) {
                next = curr.next; // Get hold of the next LinkedNode
                curr.next = prev; // Make the current LinkedNode point towards previous
                prev = curr; // Move the previous LinkedNode
                curr = next; // Move the current LinkedNode
            }
            head = prev; // Set the head pointer towards the previous item
        }
    }

    // Helper function for reversing using recursion
    void reverseRecusion() {
        if (head == null) {
            System.out.println("List Empty");
        } else {
            LinkedNode curr = head.next;
            head.next = null;
            switchLink(head, curr);
        }
    }

    // Recursive function for reversing the linked list
    private void switchLink(LinkedNode prev, LinkedNode curr) {
        if (curr == null) {
            head = prev;
            return;
        }
        LinkedNode next = curr.next;
        curr.next = prev;
        switchLink(curr, next);
    }

    // Display the linked list
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        LinkedNode temp = head;
        while (temp != null) {
            result.append(temp.data + ", ");
            temp = temp.next;
        }
        result.append("]");
        return result.toString();
    }

    // Sorted insert
    void sortedInsert(int data) {
        LinkedNode curr = head, prev = head;
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
            LinkedNode newNode = new LinkedNode(data);
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
        LinkedNode slow = head, fast = head;
        while (fast != null && fast.next != null) { // For even elements fast is null otherwise fast.next is null
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedNode newNode = new LinkedNode(data);
        newNode.next = slow.next;
        slow.next = newNode;
    }

}

public class SinglyLinkedList {
    // Adds the 2nd linked list at end of the 1st linked list
    public static void joinLinkedList(MyLinkedList l1, MyLinkedList l2) {
        LinkedNode curr = l1.head;
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
