package MyExceptionPackage;

import java.lang.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    MyLogger myLogger = new MyLogger();
    private static float x;
    private static float y;

    public float addition(float x, float y) {
        return x + y;
    }

    public float subtraction(float x, float y) {
        return x - y;
    }

    public float multiplication(float x, float y) {
        return x * y;
    }

    public int division(int x, int y) {
        return x / y;
        }

    public void calc() {
        Scanner sc = new Scanner(System.in);
        int ops = sc.nextInt();
        myLogger.log("operand 1: ");
        try { //when user doesn`t enter numbers , user get message
            x = sc.nextFloat();
            myLogger.log("operand 2: ");
            y = sc.nextInt();
        } catch (InputMismatchException ex) {
            myLogger.log("/////Введено не число//////\n Введите заново");

        }
        switch (ops) {
            case (1):
                myLogger.log("x + y = " + addition(x, y));
                break;
            case (2):
                myLogger.log("x - y = " + subtraction(x, y));
                break;
            case (3):
                myLogger.log("x * y = " + multiplication(x, y));
                break;
            case (4):
                try { // when user enter second operand "0" , get message about division by zero
                    if (y == 0) {
                        throw new MyException(y);
                    }
                    division((int) x, (int) y);
                } catch (MyException e) {
                    myLogger.log("You can`t divine by " + e.getNumber() + " , try again");
                    myLogger.log("What operation? (1 = '+', 2 = '-', 3 = '*', 4 = '/')");
                    calc();
                }
            default:
                break;
        }
    }
}
