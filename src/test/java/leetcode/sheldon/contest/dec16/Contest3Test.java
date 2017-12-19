package leetcode.sheldon.contest.dec16;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/16/17.
 * @version 1.0
 */
public class Contest3Test {
    @Test
    public void countCornerRectangles() throws Exception {
        Contest3 contest3 = new Contest3();

        int[][] grid = new int[][] {
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };
        assertEquals(1, contest3.countCornerRectangles(grid));

        grid = new int[][] {
                {0,1,0},{1,0,1},{1,0,1},{0,1,0}
        };

        assertEquals(1, contest3.countCornerRectangles(grid));

        grid = new int[][] {
                {0,0,0,0},{1,0,0,1},{0,1,1,1},{1,1,1,1}
        };
        assertEquals(4, contest3.countCornerRectangles(grid));
    }

}