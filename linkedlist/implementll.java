package linkedlist;

class node {
    int data;
    node next;

    public node(int data) {
        this.data = data;
        // this.next = null;
    }
}

class linkedList {
    node head;

    void insert(int data, int pos) {
        node new_node = new node(data);
        if (pos == 0) {
            head = new_node;
        } else {
            node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            new_node.next = temp.next;
            temp.next = new_node;
        }
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

}

public class implementll {
    public static void main(String[] args) {
        linkedList ob = new linkedList();
        ob.insert(2, 0);
        ob.display();
    }

}
