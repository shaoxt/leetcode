package leetcode.sheldon.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 3/17/18.
 * @version 1.0
 */
public class CountAndSayTest {
    @Test
    public void countAndSay() throws Exception {
        CountAndSay countAndSay = new CountAndSay();
        assertEquals("1", countAndSay.countAndSay(1));
        assertEquals("21", countAndSay.countAndSay(3));
        assertEquals("1113213211", countAndSay.countAndSay(8));

    }

}