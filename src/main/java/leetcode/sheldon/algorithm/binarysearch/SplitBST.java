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
package leetcode.sheldon.algorithm.binarysearch;

import leetcode.sheldon.algorithm.tree.TreeNode;

/**
 * 776
 *
 * Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value.  It's not necessarily the case that the tree contains a node with value V.

 Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in the original tree, if they are both in the same subtree after the split, then node C should still have the parent P.

 You should output the root TreeNode of both subtrees after splitting, in any order.

 Example 1:

 Input: root = [4,2,6,1,3,5,7], V = 2
 Output: [[2,1],[4,3,6,null,null,5,7]]
 Explanation:
 Note that root, output[0], and output[1] are TreeNode objects, not arrays.

 The given tree [4,2,6,1,3,5,7] is represented by the following diagram:

 4
 /   \
 2      6
 / \    / \
 1   3  5   7

 while the diagrams for the outputs are:

 4
 /   \
 3      6      and    2
 / \           /
 5   7         1
 Note:

 The size of the BST will not exceed 50.
 The BST is always valid and each node's value is different.


 * @author Sheldon Shao xshao@ebay.com on 3/31/18.
 * @version 1.0
 */
public class SplitBST {
    
    public TreeNode[] splitBST(TreeNode node, int V) {
        if (node == null) {
            return new TreeNode[2];
        }
        TreeNode[] treeNodes = null;
        if (node.val != V) {
            if (V < node.val) {
                if (node.left != null) {
                    if (V <= node.left.val) {
                        treeNodes = splitBST(node.left, V);
                        if (treeNodes != null) {
                            node.left = treeNodes[1];
                            treeNodes[1] = node;
                            return treeNodes;
                        }
                    }
                }
            }
            else {
                if (node.right != null) {
                    if (V > node.right.val) {
                        treeNodes = splitBST(node.right, V);
                        if (treeNodes != null) {
                            node.right = treeNodes[0];
                            treeNodes[0] = node;
                            return treeNodes;
                        }
                    }
                }
            }
        }

        if (node.val <= V) {
            TreeNode right = node.right;
            node.right = null;
            return new TreeNode[] {node, right};
        }
        else {
            TreeNode left = node.left;
            node.left = null;
            return new TreeNode[] {left, node};
        }
    }
}
