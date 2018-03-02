package leetcode.sheldon.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 2/19/18.
 * @version 1.0
 */
public class FindModeBinarySearchTreeTest {

    @Test
    public void findMode0() throws Exception {
        TreeNode root = new TreeNode(1);

        FindModeBinarySearchTree searchTree = new FindModeBinarySearchTree();
        int[] result = searchTree.findMode(root);
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals(1, result[0]);
    }


    @Test
    public void findMode3() throws Exception {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        FindModeBinarySearchTree searchTree = new FindModeBinarySearchTree();
        int[] result = searchTree.findMode(root);
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(1, result[0]);
    }


    @Test
    public void findMode() throws Exception {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        FindModeBinarySearchTree searchTree = new FindModeBinarySearchTree();
        int[] result = searchTree.findMode(root);
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals(2, result[0]);
    }

    @Test
    public void findMode1() throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        FindModeBinarySearchTree searchTree = new FindModeBinarySearchTree();
        int[] result = searchTree.findMode(root);
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals(1, result[0]);
    }
    @Test
    public void findMode4() throws Exception {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(6);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        FindModeBinarySearchTree searchTree = new FindModeBinarySearchTree();
        int[] result = searchTree.findMode(root);
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(2, result[0]);
    }
}