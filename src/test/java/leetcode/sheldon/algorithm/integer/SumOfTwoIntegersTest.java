package leetcode.sheldon.algorithm.integer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/9/17.
 * @version 1.0
 */
public class SumOfTwoIntegersTest {
    @Test
    public void divide() throws Exception {
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        assertEquals(6, sumOfTwoIntegers.divide(18, 3));
        assertEquals(8, sumOfTwoIntegers.divide(25, 3));
    }

    @Test
    public void getMultiply() throws Exception {
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        assertEquals(18, sumOfTwoIntegers.getMultiply(3, 6));
        assertEquals(18, sumOfTwoIntegers.getMultiply(-3, -6));
        assertEquals(-18, sumOfTwoIntegers.getMultiply(3, -6));
        assertEquals(-2147483648, sumOfTwoIntegers.getMultiply(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void getSum() throws Exception {
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        assertEquals(0, sumOfTwoIntegers.getSum(1, -1));
    }

    @Test
    public void getSubtract() throws Exception {
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        assertEquals(0, sumOfTwoIntegers.getSubtract(1, 1));
        assertEquals(0, sumOfTwoIntegers.getSubtract(Integer.MIN_VALUE, Integer.MIN_VALUE));
        assertEquals(0, sumOfTwoIntegers.getSubtract(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

}