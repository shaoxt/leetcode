package leetcode.sheldon.contest.dec30;

import leetcode.sheldon.contest.dec30.Contest1;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/30/17.
 * @version 1.0
 */
public class Contest1Test {
    @Test
    public void reachNumber() throws Exception {
        Contest1 contest1 = new Contest1();
//        assertEquals(2, contest1.reachNumber(3));
//        assertEquals(3, contest1.reachNumber(2));
//        assertEquals(4, contest1.reachNumber(10));
//        assertEquals(6, contest1.reachNumber(9));
//        assertEquals(3, contest1.reachNumber(6));
        assertEquals(3, contest1.reachNumber(4));
        assertEquals(5, contest1.reachNumber(7));
        assertEquals(7, contest1.reachNumber(8));
        assertEquals(1, contest1.reachNumber(-1));
    }

}