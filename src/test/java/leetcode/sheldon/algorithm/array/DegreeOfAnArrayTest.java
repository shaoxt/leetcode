package leetcode.sheldon.algorithm.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/19/17.
 * @version 1.0
 */
public class DegreeOfAnArrayTest {
    @Test
    public void findShortestSubArray() throws Exception {

        int[] array = {1,2,2,3,1,4,2};
        DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();
        int value = degreeOfAnArray.findShortestSubArray(array);
        assertEquals(6, value);
    }

}