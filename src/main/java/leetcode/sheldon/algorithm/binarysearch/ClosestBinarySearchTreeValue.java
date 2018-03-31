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
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 *
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 * @author Sheldon Shao xshao@ebay.com on 3/31/18.
 * @version 1.0
 */
public class ClosestBinarySearchTreeValue {

    //O(LOG(N)) Binary Search
    public int closestValue(TreeNode root, double target) {
        int[] lastValue = new int[1];
        double[] lastDelta = new double[1];
        lastValue[0] = root.val;
        lastDelta[0] = Math.abs(root.val - target);
        return closestValue(root, target, lastValue, lastDelta);
    }

    /*
       1
      /  \
     -1  3
        /  \
        2   4

        // target = 2.4

     */
    //DFS inorder
    private int closestValue(TreeNode root, double target, int[] lastValue, double[] lastDelta) {
        double delta = Math.abs(root.val - target);
        if (delta < lastDelta[0]) {  // 0.4 0.6
            lastDelta[0] = delta;
            lastValue[0] = root.val;
        }

        if (root.val > target && root.left != null) { //Check left
            return closestValue(root.left, target, lastValue, lastDelta);
        }

        if (root.val < target && root.right != null) { //Go right
            return closestValue(root.right, target, lastValue, lastDelta);
        }

        return lastValue[0];
    }

}
