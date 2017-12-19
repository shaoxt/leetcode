package leetcode.sheldon.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/18/17.
 * @version 1.0
 */
public class MinimumAbsoluteDifferenceBSTTest {
    @Test
    public void getMinimumDifference() throws Exception {
        TreeNode treeNode = new TreeNode(1476);
        treeNode.left = new TreeNode(1054);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.left.right = new TreeNode(215);
        treeNode.left.left.right.right = new TreeNode(745);

        MinimumAbsoluteDifferenceBST solution = new MinimumAbsoluteDifferenceBST();
        assertEquals(214, solution.getMinimumDifference(treeNode));
    }

}