package leetcode.sheldon.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/5/18.
 * @version 1.0
 */
public class LongestWordTest {
    @Test
    public void longestWord() throws Exception {
        LongestWord word = new LongestWord();
        assertEquals("apple", word.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

}