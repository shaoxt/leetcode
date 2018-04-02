package leetcode.sheldon.algorithm.binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 3/31/18.
 * @version 1.0
 */
public class VerifyPreorderQequenceInBinarySearchTreeTest {
    @Test
    public void verifyPreorder() throws Exception {
        VerifyPreorderQequenceInBinarySearchTree verifyPreorderQequenceInBinarySearchTree = new VerifyPreorderQequenceInBinarySearchTree();
        assertFalse(verifyPreorderQequenceInBinarySearchTree.verifyPreorder(new int[] { 3, 1, 4, 2}));
    }

}