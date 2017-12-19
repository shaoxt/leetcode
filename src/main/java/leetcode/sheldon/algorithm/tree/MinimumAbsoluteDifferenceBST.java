/**
 * Copyright (c) 2016 eBay Software Foundation. All rights reserved.
 * <p>
 * Licensed under the MIT license.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * <p>
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package leetcode.sheldon.algorithm.tree;

/**
 *
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 * 1
 * \
 * 3
 * /
 * 2
 *
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 *
 * @author Sheldon Shao xshao@ebay.com on 12/18/17.
 * @version 1.0
 */
public class MinimumAbsoluteDifferenceBST {

    public int getMinimumDifference(TreeNode root) {
        int minRoot = getMinimumDifferenceFor(root);
        int minLeftNode = root.left != null ? getMinimumDifference(root.left) : Integer.MAX_VALUE;
        int minRightNode = root.right != null ? getMinimumDifference(root.right) : Integer.MAX_VALUE;
        return Math.min(Math.min(minRoot, minLeftNode), minRightNode);
    }

    public int getMinimumDifferenceFor(TreeNode node) {
        int minLeft = Integer.MAX_VALUE;
        TreeNode n = node.left;
        if (n != null) {
            while(n.right != null) {
                n = n.right;
            }
            minLeft = node.val-n.val;
        }
        int minRight = Integer.MAX_VALUE;
        n = node.right;
        if (n != null) {
            while(n.left != null) {
                n = n.left;
            }
            minRight = n.val - node.val;
        }
        return Math.min(minRight, minLeft);
    }
}
