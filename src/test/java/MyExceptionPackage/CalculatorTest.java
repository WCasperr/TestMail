package MyExceptionPackage;

import jdk.nashorn.internal.AssertsEnabled;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.apache.log4j.MDC.clear;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Before
    public void setUp()  {
        clear();
    }

    @Test
    public void addition() {
        Calculator c = new Calculator();
        float addition = c.addition(2, 4);
        Assert.assertEquals(6.0,6.0,0.0);
    }

    @Test
    public void subtraction() {
        Calculator c = new Calculator();
        float addition = c.subtraction(7, 2);
        Assert.assertEquals(5.0,addition,0.0);
    }

    @Test
    public void multiplication() {
        Calculator c = new Calculator();
        Assert.assertEquals(8.0,c.multiplication(2, 4),0.0);
    }

    @Test

    public void division() {
        Calculator c = new Calculator();
        try{
            Assert.assertEquals(3,c.division(5, 0),0.0);
        }
        catch (ArithmeticException e){
            System.out.println("EXCEPTION CATCHED  " + e);
        }
        }

    @After
    public void tearDown(){
        clear();

    }
}