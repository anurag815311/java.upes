package linkedlist;

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

    public static void DisplayRev(Node head) {
        if (head == null) {
            return;
        }
        DisplayRev(head);
        System.out.print(head.data + " ");

    }

    public static int len(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    void insert(Node head, int pos, int data) { // will not work for pos==0 as we have not intialized
        Node newNode = new Node(data);
        Node temp = head;
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;

        }
    }

    void insert_at_end(Node head, int data) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void main(String[] args) {
        basicll ob = new basicll();
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        // Display(a);
        // System.out.println();
        // DisplayR(a);
        ob.insert(a, 3, 34);
        ob.insert(a, 1, 120);
        ob.insert_at_end(a, 21);
        Display(a);
    }

}