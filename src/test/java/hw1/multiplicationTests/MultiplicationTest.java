package hw1.multiplicationTests;

import hw1.BasicTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplicationTest extends BasicTest {

    @DataProvider
    public Object[][] multiplyTwoLongNumbersDataProvider(){
        return new Object[][] {
                {9L, 2L, 18L},
                {0L, 2L, 0L},
                {2L, -3L, -6L},
                {-3L, -3L, 9L}
        };
    }
    @Test(dataProvider = "multiplyTwoLongNumbersDataProvider")
    public void multiplyTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult){
        long actualResult = calculator.mult(firstNumber, secondNumber);
        assertEquals(actualResult, expectedResult);    }

    @DataProvider
    public Object[][] multiplyTwoDoubleNumbersDataProvider(){
        return new Object[][] {
                {5.0, -2.0, -10.0},
                {0.0, 2.0, 0.0},
                {0.25, 4.0, 1.0}
        };
    }

    @Test(dataProvider = "multiplyTwoDoubleNumbersDataProvider")
    public void multiplyTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult){
        double actualResult = calculator.mult(firstNumber, secondNumber);
        assertEquals(actualResult, expectedResult);
    }
}

