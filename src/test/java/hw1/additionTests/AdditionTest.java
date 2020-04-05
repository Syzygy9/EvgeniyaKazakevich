package hw1.additionTests;

import hw1.BasicTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AdditionTest extends BasicTest {

    @DataProvider
    public Object[][] addTwoLongNumbersDataProvider() {
        return new Object[][]{
                {11L, 33L, 44L},
                {0L, 0L, 0L},
                {2L, 5L, 7L},
                {-8L, 3L, -5L},
                {-1L, -1L, -2L}
        };
    }

    @Test(dataProvider = "addTwoLongNumbersDataProvider")
    public void addTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.sum(firstNumber, secondNumber);

        assertEquals(actualResult, expectedResult);
    }

    @DataProvider
    public Object[][] addTwoDoubleNumbersDataProvider() {
        return new Object[][]{
                {35.0, 2.0, 37.0},
                {0.1, 0.9, 1.0},
                {0.0, 0.0, 0.0}
        };
    }

    @Test(dataProvider = "addTwoDoubleNumbersDataProvider")
    public void addTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult) {
        double actualResult = calculator.sum(firstNumber, secondNumber);

        assertEquals(actualResult, expectedResult);
    }
}

