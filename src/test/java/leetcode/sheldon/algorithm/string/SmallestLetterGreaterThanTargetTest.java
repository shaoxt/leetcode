package leetcode.sheldon.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/9/17.
 * @version 1.0
 */
public class SmallestLetterGreaterThanTargetTest {
    @Test
    public void nextGreatestLetter() throws Exception {

        SmallestLetterGreaterThanTarget smallestLetterGreaterThanTarget = new SmallestLetterGreaterThanTarget();
        assertEquals('c', smallestLetterGreaterThanTarget.nextGreatestLetter(new char[] { 'c', 'f', 'j'}, 'a'));
    }

}