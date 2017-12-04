package leetcode.sheldon.algorithm.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/2/17.
 * @version 1.0
 */
public class DeleteAndEarnTest {
    @Test
    public void deleteAndEarn1() throws Exception {
    }

    @Test
    public void deleteAndEarn() throws Exception {
        DeleteAndEarn earn = new DeleteAndEarn();
        assertEquals(6, earn.deleteAndEarn(new int[] {3, 4, 2}));
        assertEquals(9, earn.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
        assertEquals(37, earn.deleteAndEarn(new int[] {8,10,4,9,1,3,5,9,4,10}));
    }

}
