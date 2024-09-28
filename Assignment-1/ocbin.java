
/*Write a Java program that takes an integer as input from the user, and if the
number is prime, then the binary representation of the number is printed; else
if the number is not prime, then the octal representation of the number is
printed. [DO NOT USE IN-BUILT FUNCTIONS TO GET THE BINARY
AND OCTAL REPRESENTATIONS] */
import java.util.Scanner;

public class ocbin {
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static String toBinary(int num) {
        StringBuilder binary = new StringBuilder();
        while (num > 0) {
            binary.append(num % 2);
            num /= 2;
        }
        return binary.reverse().toString();
    }

    public static String toOctal(int num) {
        StringBuilder octal = new StringBuilder();
        while (num > 0) {
            octal.append(num % 8);
            num /= 8;
        }
        return octal.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int number = sc.nextInt();

        if (isPrime(number)) {
            System.out.println("The number is prime. Binary representation: " + toBinary(number));
        } else {
            System.out.println("The number is not prime. Octal representation: " + toOctal(number));
        }
        sc.close();
    }

}
