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
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

 Example 1:
 Input:
 1
 / \
 0   2

 L = 1
 R = 2

 Output:
 1
 \
 2
 Example 2:
 Input:
 3
 / \
 0   4
 \
 2
 /
 1

 L = 1
 R = 3

 Output:
 3
 /
 2
 /
 1

 * @author Sheldon Shao xshao@ebay.com on 12/4/17.
 * @version 1.0
 */
public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root != null) {
            TreeNode leftNode = trimBST(root.left, L, R);
            TreeNode rightNode = trimBST(root.right, L, R);

            if (root.val >= L && root.val <= R) { //Keep this
                root.left = leftNode;
                root.right = rightNode;
                return root;
            }
            else { //Delete this
                if (leftNode != null) {
                    if (rightNode == null) {
                        return leftNode;
                    }
                    else {//Both have validate node
                        TreeNode node = leftNode;
                        while(node.right != null) {
                            node = node.right;
                        }
                        //Append the right node onto the first find non-existed right node
                        node.right = rightNode;
                        return leftNode;
                    }
                }
                else {
                    return rightNode;
                }
            }
        }
        return null;
    }
}
