package MyExceptionPackage;

import java.util.Scanner;

public class DemoClass {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("What operation? ('+', '-', '*', '/')");
        System.out.println(" Enter 1 for Addition");
        System.out.println(" Enter 2 for Subtraction");
        System.out.println(" Enter 3 for Multiplication");
        System.out.println(" Enter 4 for Division");
        Scanner sc = new Scanner(System.in);
        calc.calc();
    }
}
