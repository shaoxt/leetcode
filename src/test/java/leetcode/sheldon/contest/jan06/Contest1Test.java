package leetcode.sheldon.contest.jan06;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/6/18.
 * @version 1.0
 */
public class Contest1Test {
    @Test
    public void anagramMappings() throws Exception {
        Contest1 contest1 = new Contest1();
        assertArrayEquals(new int[] {1, 4, 3, 2, 0}, contest1.anagramMappings(new int[] {12, 28, 46, 32, 50},
                new int[] {50, 12, 32, 46, 28}));

    }

}