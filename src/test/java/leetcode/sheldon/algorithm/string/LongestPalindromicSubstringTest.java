package leetcode.sheldon.algorithm.string;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/2/17.
 * @version 1.0
 */
public class LongestPalindromicSubstringTest {
    @org.junit.Test
    public void longestPalindromicSubstring() throws Exception {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();

        assertEquals("aaaaaaaaaaaaaaaaaaaaaaaaaaaa", test.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals("abcba", test.longestPalindrome("abcbad"));
        assertEquals("abcba", test.longestPalindrome("abcba"));
        assertEquals("aba", test.longestPalindrome("babad"));
        assertEquals("bb", test.longestPalindrome("cbbd"));
    }

//    @org.junit.Test
//    public void isPalindromic() throws Exception {
//        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
//        byte[][] scanned = new byte[1000][1000];
//        assertTrue(test.isPalindromic("abcba", 0, 5, scanned));
//        scanned = new byte[1000][1000];
//        assertTrue(test.isPalindromic("abcbad", 0, 5, scanned));
//        scanned = new byte[1000][1000];
//        assertTrue(test.isPalindromic("abcbad", 1, 4, scanned));
//        scanned = new byte[1000][1000];
//        assertFalse(test.isPalindromic("abcbad", 2, 4, scanned));
//    }

}
