package hw1.divisionTests;

import hw1.BasicTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivisionTest extends BasicTest {


    @DataProvider
    public Object[][] divideTwoLongNumbersDataProvider(){
        return new Object[][] {
                {20L, 2L, 10L},
                {100L, 4L, 25L},
                {0L, 30L, 0L}
        };
    }

    @Test(dataProvider = "divideTwoLongNumbersDataProvider")
    public void divideTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult){
        long actualResult = calculator.div(firstNumber, secondNumber);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider
    public Object[][] divideTwoDoubleNumbersDataProvider(){
        return new Object[][] {
                {60.0, 20.0, 3.0},
                {0.100, -2.0, -0.05},
                {10.00, 2.00, 5.00}
        };
    }

    @Test(dataProvider = "divideTwoDoubleNumbersDataProvider")
    public void divideTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult){
        double actualResult = calculator.div(firstNumber, secondNumber);
        assertEquals(actualResult, expectedResult);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void throwsNumberFormatException() {
        calculator.div(50, 0);
    }
}

