
/* Write a Java program that takes a double, say x, as input from the user and
prints y = ceiling(x) [lowest integer number greater than x]. Next, implement
a function to print the 2’s complement corresponding to the number y
*/
import java.util.Scanner;

public class ciel_twocomp {
    public static int ceiling(double x) {
        return (int) Math.ceil(x);
    }

    public static void printTwosComplement(int y) {
        int twosComplement = ~y + 1;
        System.out.println("2's complement of y: " + twosComplement);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a double value: ");
        double x = sc.nextDouble();

        int y = ceiling(x);
        System.out.println("Ceiling of " + x + " is: " + y);

        printTwosComplement(y);

        sc.close();
    }
}