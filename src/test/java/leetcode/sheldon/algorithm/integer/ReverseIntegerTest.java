package leetcode.sheldon.algorithm.integer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/2/17.
 * @version 1.0
 */
public class ReverseIntegerTest {
    @Test
    public void reverse() throws Exception {
        assertEquals(-2143847412, new ReverseInteger().reverse(-2147483412));
    }

}
