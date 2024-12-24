package DSA;

public class DeleteMiddle {
    public static Node solver(Node head){
        Node fast = head, slow = head, prev = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(slow == fast){
            return null;
        }
        prev.next = slow.next;
        return head;
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
        solver(head);
        System.out.println("After");
        display(head);
    }
}
