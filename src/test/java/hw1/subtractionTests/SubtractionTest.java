package hw1.subtractionTests;

import hw1.BasicTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractionTest extends BasicTest {

        @DataProvider
        public Object[][] subtractTwoLongNumbersDataProvider(){
            return new Object[][] {
                    {10L, 2L, 8L},
                    {0L, 7L, -7L},
                    {-9L, 6L, -15L},
                    {17L, 17L, 0L}
            };
        }

        @Test(dataProvider = "subtractTwoLongNumbersDataProvider")
        public void subtractTwoLongNumbers(long firstNumber, long secondNumber, long expectedResult) {
            long actualResult = calculator.sub(firstNumber, secondNumber);

            assertEquals(actualResult, expectedResult);
        }

        @DataProvider
        public Object[][] subtractTwoDoubleNumbersDataProvider(){
            return new Object[][] {
                    {8.4, 8.4, 0.0},
                    {-21.5, -9.5, -12.0},
                    {33.25, 31.25, 2.0},
                    {2.5, 3.0, -0.5}
            };
        }

        @Test(dataProvider = "subtractTwoDoubleNumbersDataProvider")
        public void subtractTwoDoubleNumbers(double firstNumber, double secondNumber, double expectedResult) {
            double actualResult = calculator.sub(firstNumber, secondNumber);

            assertEquals(actualResult, expectedResult);
        }
    }

