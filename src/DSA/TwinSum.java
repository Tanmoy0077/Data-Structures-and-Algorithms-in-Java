package DSA;

public class TwinSum {
    public static int solver(Node head){
        // Find the middle of the linked list
        Node prev=head, slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the second half of the linked list
        prev.next = reverse(slow);
        prev = prev.next;
        // Use two pointer approach to find maximum pair
        int maxSum = 0;
        Node start = head;
        while(prev != null){
            maxSum = Math.max(maxSum, start.val + prev.val);
            start = start.next;
            prev = prev.next;
        }
        
        return maxSum;
    }
    public static Node reverse(Node head){
        Node prev = null, curr = head, next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
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
        // Length of the linked list must be even
        Node head = new Node(1);
        head.next = new Node(1000);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println("Maximum Twin sum is : "+solver(head));
    }
}
