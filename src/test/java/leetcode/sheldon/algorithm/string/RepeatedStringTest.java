package leetcode.sheldon.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/21/18.
 * @version 1.0
 */
public class RepeatedStringTest {
    @Test
    public void repeatedSubstringPattern() throws Exception {

        RepeatedString repeatedString = new RepeatedString();
        assertTrue(repeatedString.repeatedSubstringPattern("abababaabababaabababa"));
    }

}