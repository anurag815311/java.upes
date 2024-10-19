package linked_list;

public class basicll {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void Display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void DisplayR(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        DisplayR(head.next);

    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Display(a);
        System.out.println();
        DisplayR(a);
    }

}
