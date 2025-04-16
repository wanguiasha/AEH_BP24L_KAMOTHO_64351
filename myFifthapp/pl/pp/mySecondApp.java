package pl.pp;
import java.util.Scanner;

public class mySecondApp {

    public static void main(String[] args) {

                // Task 1: Create an integer variable x and perform calculations
                int x = 10;
                int doubleX = x * 2;
                int squaredX = x * x;

                System.out.println("x = " + x);
                System.out.println("Double of x: " + doubleX);
                System.out.println("x squared: " + squaredX);

                // Task 2: Ask for age and convert it to seconds
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your age in years: ");
                int age = scanner.nextInt();
                long ageInSeconds = (long) age * 365 * 24 * 60 * 60; // Approximate conversion

                System.out.println("My age in seconds: " + ageInSeconds);

                scanner.close();
    }
}


