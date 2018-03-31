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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 *
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 *
 * @author Sheldon Shao xshao@ebay.com on 3/31/18.
 * @version 1.0
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        // 1 as root:  P(0) + P(N-1)
        // 2 as root:  P(1) + P(N-2)
        // ...
        // N as root:  P(N-1) + P(0)
        if (n == 0) {
            return Collections.emptyList();
        }
        return generateTrees(1, n);
    }


    public List<TreeNode> generateTrees(int start, int end) {
        // 1 as root:  P(0) + P(N-1)
        // 2 as root:  P(1) + P(N-2)
        // ...
        // N as root:  P(N-1) + P(0)
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        else if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        for(int r = start; r <= end; r ++) {
            List<TreeNode> leftPermutation = generateTrees(start, r - 1);
            List<TreeNode> rightPermutation = generateTrees(r + 1, end);
            for (TreeNode left : leftPermutation) {
                for (TreeNode right : rightPermutation) {
                    TreeNode root = new TreeNode(r);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
