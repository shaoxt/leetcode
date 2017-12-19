package leetcode.sheldon.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/10/17.
 * @version 1.0
 */
public class ClosestLeafInABinaryTreeTest {
    @Test
    public void findClosestLeaf() throws Exception {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(5);
        treeNode.left.left.left.left = new TreeNode(6);

        ClosestLeafInABinaryTree solution = new ClosestLeafInABinaryTree();
        assertEquals(3, solution.findClosestLeaf(treeNode, 2));
    }

    @Test
    public void findClosestLeaf1() throws Exception {
    }

    @Test
    public void findNode() throws Exception {
    }

}