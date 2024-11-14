package DSA;


public class OddEvenList {
    public static Node solver(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        Node curr = head.next.next, prev = head.next;
        Node odd = head;
        Node temp;
        while(curr != null){
            // Remove the odd node from its position
            prev.next = curr.next;
            // Insert it after the last odd node
            temp = odd.next;
            odd.next = curr;
            curr.next = temp;
            // Update the last odd node
            odd = odd.next;
            // Skip the even node
            curr = prev.next;
            if(curr != null){
                prev = curr;
                curr = curr.next;
            }
        }
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
        head = solver(head);
        System.out.println("After");
        display(head);
    }
}
