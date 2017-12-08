package leetcode.sheldon.algorithm.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/7/17.
 * @version 1.0
 */
public class MaxAreaOfIslandTest {
    @Test
    public void maxAreaOfIsland() throws Exception {

        MaxAreaOfIsland island = new MaxAreaOfIsland();
        assertEquals(4, island.maxAreaOfIsland(new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
    }

}