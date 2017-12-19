package leetcode.sheldon.contest.dec16;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/16/17.
 * @version 1.0
 */
public class Contest2Test {
    @Test
    public void shortestCompletingWord() throws Exception {
        Contest2 contest2 = new Contest2();
        assertEquals("steps", contest2.shortestCompletingWord("1s3 PSt",
                new String[] {"step","steps","stripe","stepple"}));
    }

}