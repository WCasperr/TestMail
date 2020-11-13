package MyExceptionPackage;

public class MyException extends ArithmeticException{
    private float number;

    public MyException(float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }
}
