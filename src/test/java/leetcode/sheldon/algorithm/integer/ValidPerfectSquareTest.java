package leetcode.sheldon.algorithm.integer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/16/18.
 * @version 1.0
 */
public class ValidPerfectSquareTest {
    @Test
    public void isPerfectSquare() throws Exception {
        ValidPerfectSquare square = new ValidPerfectSquare();
//        assertTrue(square.isPerfectSquare(9));
        assertTrue(square.isPerfectSquare(2147395600));
    }

}