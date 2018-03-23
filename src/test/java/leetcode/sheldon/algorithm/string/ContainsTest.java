package leetcode.sheldon.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 3/22/18.
 * @version 1.0
 */
public class ContainsTest {
    @Test
    public void contains() throws Exception {
        assertEquals(Contains.contains("abc", ""), true);
        assertEquals(Contains.contains("ab", "ab"), true);
        assertEquals(Contains.contains("ab", "abc"), false);
        assertEquals(Contains.contains("adfadfadsfadfs", "fad"), true);
        assertEquals(Contains.contains("aaaaaaaabbbb", "bbb"), true);
        assertEquals(Contains.contains("aaaaaaaabbbb", "aaaabbbb"), true);
        assertEquals(Contains.contains("aaaaa99888777", "99877"), false);
    }

}