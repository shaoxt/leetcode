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
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * @author Sheldon Shao xshao@ebay.com on 3/31/18.
 * @version 1.0
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer[] prev = new Integer[0];
        return visitBST(root, prev);
    }

    //DFS inorder (LEFT ROOT RIGHT)
    public boolean visitBST(TreeNode root, Integer[] prev) {
        boolean isValid = true;
        if (root.left != null) {
            isValid = visitBST(root.left, prev);
            if (!isValid) {
                return false;
            }
        }
        if (prev[0] != null && prev[0] >= root.val) {
            return false;
        }
        prev[0] = root.val;
        if (root.right != null) {
            isValid = visitBST(root.right, prev);
            if (!isValid) {
                return false;
            }
        }
        return isValid;
    }
}
