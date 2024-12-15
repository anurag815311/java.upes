package stack;

public class stackil {

    int stack[];
    int top;
    int size;

    public stackil(int stackSize) {
        stack = new int[stackSize];
        size = stackSize;
        top = -1;
    }

    public void push(int element) {
        if (top >= size - 1) {
            System.out.println("Stack is full");
        }
        top++;
        stack[top] = element;
    }

    public boolean isEmpty() {
        return top <= -1;
    }

    public int size() {
        return top + 1;
    }

    public int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }

    public int pop() {
        int val = peek();
        if (val != Integer.MAX_VALUE) {
            top--;
        }
        return val;
    }

    public void printStack() {
        System.out.println("Printing Stack");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i]);
            if (i != top) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        stackil stack = new stackil(n);
        System.out.println("isEmpty :" + stack.isEmpty());
        stack.push(23);
        stack.printStack();
        stack.push(34);
        stack.push(45);
        stack.push(47);
        stack.printStack();
        stack.push(46);
        stack.printStack();
        // stack.push(34);
        stack.pop();
        stack.printStack();

    }
}
