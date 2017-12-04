package leetcode.sheldon.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/3/17.
 * @version 1.0
 */
public class RegularExpressionMatchingTest {
    @Test
    public void isMatch() throws Exception {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        assertFalse(matching.isMatch("aa","a"));
        assertTrue(matching.isMatch("aa","aa"));
        assertFalse(matching.isMatch("aaa","aa"));
        assertTrue(matching.isMatch("aaa","a*a"));
        assertTrue(matching.isMatch("aa","a*"));
        assertTrue(matching.isMatch("aa",".*"));
        assertTrue(matching.isMatch("ab",".*"));
        assertTrue(matching.isMatch("aab","c*a*b"));
        assertFalse(matching.isMatch("ab",".*c"));
        assertTrue(matching.isMatch("aaa", "ab*ac*a"));
        assertFalse(matching.isMatch("aaa", "aaaa"));
        assertTrue(matching.isMatch("a", "ab*"));
    }
}
