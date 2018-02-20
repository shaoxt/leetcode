package leetcode.sheldon.contest.jan13;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/13/18.
 * @version 1.0
 */
public class Contest1Test {
    @Test
    public void test() {
        Contest1 contest1 = new Contest1();
//        assertEquals(4, contest1.countPrimeSetBits(6, 10));
//        assertEquals(5, contest1.countPrimeSetBits(10, 15));
        assertEquals(1465, contest1.countPrimeSetBits(289051, 294301));
    }
}