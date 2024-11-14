package DSA;

public class ReverseList {
    public static Node solver(Node head){
        Node prev = null;
        Node curr = head;
        Node temp;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static void display(Node head){
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println("Before");
        display(head);
        head = solver(head);
        System.out.println("After");
        display(head);
    }
}
