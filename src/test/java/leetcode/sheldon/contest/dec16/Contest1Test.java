package leetcode.sheldon.contest.dec16;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/16/17.
 * @version 1.0
 */
public class Contest1Test {
    @Test
    public void minCostClimbingStairs() throws Exception {
        Contest1 contest1 = new Contest1();
//        assertEquals(0, contest1.minCostClimbingStairs(new int[] {0, 0, 0, 0}));
//        assertEquals(15, contest1.minCostClimbingStairs(new int[] {10, 15, 20}));
        assertEquals(6, contest1.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

}