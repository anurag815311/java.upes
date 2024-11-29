public class q_one_ii {
    void calculateSum() {
        int a = 10, b = 20;
        class Adder {
            int add() {
                return a + b;
            }
        }
        Adder adder = new Adder();
        System.out.println("Sum: " + adder.add());
    }

    public static void main(String[] args) {
        q_one_ii calc = new q_one_ii();
        calc.calculateSum();
    }
}
