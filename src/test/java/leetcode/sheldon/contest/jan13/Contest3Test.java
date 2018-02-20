package leetcode.sheldon.contest.jan13;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/13/18.
 * @version 1.0
 */
public class Contest3Test {
    @Test
    public void orderOfLargestPlusSign() throws Exception {
        Contest3 contest3 = new Contest3();
        assertEquals(1, contest3.orderOfLargestPlusSign(2, new int[][] {
                {0,1},{1,0},{1,1}
        }));
        assertEquals(1, contest3.orderOfLargestPlusSign(2, new int[][] {
                {0,0},{0,1},{1,0}
        }));
        assertEquals(250, contest3.orderOfLargestPlusSign(500, new int[][] {new int[] { 249, 400}}));
        assertEquals(1, contest3.orderOfLargestPlusSign(2, new int[0][0]));
        assertEquals(0, contest3.orderOfLargestPlusSign(1, new int[][] { new int[] { 0, 0}}));
        assertEquals(2, contest3.orderOfLargestPlusSign(3, new int[][] { new int[] { 0, 0}}));


        int[][] mines = new int[4900][];
        int m = 0;
        for(int i = 215; i < 500-215; i ++) {
            for(int j = 215; j < 500-215; j ++) {
                mines[m++] = new int[] {i, j};
            }
        }
        System.out.println(contest3.orderOfLargestPlusSign(500, mines));

        assertEquals(1, contest3.orderOfLargestPlusSign(5,
                new int[][] {
                new int[] { 1, 1}, new int[] { 1, 2}, new int[] { 1, 3},
                new int[] { 2, 1}, new int[] { 2, 2}, new int[] { 2, 3},
                new int[] { 3, 1}, new int[] { 3, 2}, new int[] { 3, 3}}));
    }

}