package leetcode.sheldon.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/2/17.
 * @version 1.0
 */
public class ZigZagConversionTest {
    @Test
    public void convert() throws Exception {
        ZigZagConversion conversion = new ZigZagConversion();
        assertEquals("ABFCED", conversion.convert("ABCDEF", 4));
        assertEquals("ABCED", conversion.convert("ABCDE", 4));
    }
}
