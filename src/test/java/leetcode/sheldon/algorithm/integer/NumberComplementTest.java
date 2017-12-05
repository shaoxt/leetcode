package leetcode.sheldon.algorithm.integer;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/4/17.
 * @version 1.0
 */
public class NumberComplementTest {
    @Test
    public void findComplement() throws Exception {
        NumberComplement numberComplement = new NumberComplement();
        assertEquals(1, numberComplement.findComplement(2));
        assertEquals(2, numberComplement.findComplement(5));
    }

}
