import java.util.Scanner;

// Interface for Shapes
interface Shape {
    double area();
}

// Circle Class implementing Shape
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Rectangle Class implementing Shape
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

// Triangle Class implementing Shape
class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// Class for handling area calculations
class ShapeAreaCalculator {

    public void calculateArea(Shape shape) {
        System.out.println("Area: " + shape.area());
    }
}

// Main class for the program
public class Shapes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeAreaCalculator calculator = new ShapeAreaCalculator();
        int choice;

        while (true) {
            // Display menu options
            System.out.println("\n-- Choose a Shape to Calculate Area --");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            // Handle user input
            switch (choice) {
                case 1: // Circle
                    System.out.print("Enter the radius: ");
                    double radius = scanner.nextDouble();
                    calculator.calculateArea(new Circle(radius));
                    break;

                case 2: // Rectangle
                    System.out.print("Enter the length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter the width: ");
                    double width = scanner.nextDouble();
                    calculator.calculateArea(new Rectangle(length, width));
                    break;

                case 3: // Triangle
                    System.out.print("Enter the base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the height: ");
                    double height = scanner.nextDouble();
                    calculator.calculateArea(new Triangle(base, height));
                    break;

                case 4: // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default: // Invalid choice
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
