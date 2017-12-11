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

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree where every node has a unique value, and a target key k, find the closest leaf node to target k in the tree.

 A node is called a leaf if it has no children.

 In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

 Example 1:

 Input:
 root = [1, 3, 2], k = 1
 Diagram of binary tree:
 1
 / \
 3   2

 Output: 2 (or 3)

 Explanation: Either 2 or 3 is the closest leaf node to 1.
 Example 2:

 Input:
 root = [1], k = 1
 Output: 1

 Explanation: The closest leaf node is the root node itself.
 Example 3:

 Input:
 root = [1,2,3,4,null,null,null,5,null,6], k = 2
 Diagram of binary tree:
 1
 / \
 2   3
 /
 4
 /
 5
 /
 6

 Output: 3
 Explanation: The leaf node with value 3 (and not the leaf node with value 6) is closest to the node with value 2.
 Note:
 root represents a binary tree with at least 1 node and at most 1000 nodes.
 Every node has a unique node.val in range [1, 1000].
 There exists some node in the given binary tree for which node.val == k.

 * @author Sheldon Shao xshao@ebay.com on 12/10/17.
 * @version 1.0
 */
public class ClosestLeafInABinaryTree {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          public TreeNode(int x) { val = x; }
      }

    public int findClosestLeaf(TreeNode root, int k) {
          if (root == null) {
              return -1;
          }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode found = findNode(root, stack, k);
        if (found != null) {
            TreeNode ignoreChild;
            TreeNode node = null;
            int[] closedLeaf = new int[] { -1, Integer.MAX_VALUE};
            int dist = 0;
            while(!stack.isEmpty()) {
                ignoreChild = node;
                node = stack.pop();
                closedLeaf = findClosestLeaf(node, ignoreChild, dist, closedLeaf);
                dist ++;
            }
            return closedLeaf[0];
        }
        return -1;
    }

    public int[] findClosestLeaf(TreeNode node, TreeNode ignoreChild, int dist, int[] closedLeaf) {
          int maxDist = closedLeaf[1];
          if (dist > maxDist) {
              return closedLeaf;
          }
          boolean leaf = true;
            TreeNode l = node.left;
            if (l != null) {
                leaf = false;
                if (ignoreChild != l) {
                    closedLeaf = findClosestLeaf(l, null, dist+1, closedLeaf);
                }
            }
            TreeNode r = node.right;
            if (r != null) {
                leaf = false;
                if (ignoreChild != r) {
                    closedLeaf = findClosestLeaf(r, null, dist+1, closedLeaf);
                }
            }
            if (leaf) {
                if (closedLeaf[1] > dist) {
                    closedLeaf[0] = node.val;
                    closedLeaf[1] = dist;
                }
            }
            return closedLeaf;
    }

    public TreeNode findNode(TreeNode n, Stack<TreeNode> stack, int k) {
        stack.push(n);
        if (n.val == k) {
            return n;
        }

        TreeNode l = n.left;
        if (l != null) {
            TreeNode found = findNode(l, stack, k);
            if (found != null) {
                return found;
            }
        }

        TreeNode r = n.right;
        if (r != null) {
            TreeNode found = findNode(r, stack, k);
            if (found != null) {
                return found;
            }
        }
        stack.pop();
        return null;
    }
}
