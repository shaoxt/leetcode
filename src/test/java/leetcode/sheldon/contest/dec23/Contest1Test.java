package leetcode.sheldon.contest.dec23;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/23/17.
 * @version 1.0
 */
public class Contest1Test {
    @Test
    public void dominantIndex() throws Exception {
        Contest1 contest1 = new Contest1();
        assertEquals(1, contest1.dominantIndex(new int[] {3, 6, 1, 0}));
        assertEquals(-1, contest1.dominantIndex(new int[] {1, 2, 3, 4}));
        assertEquals(-1, contest1.dominantIndex(new int[] {0,0,3,2}));
    }

}