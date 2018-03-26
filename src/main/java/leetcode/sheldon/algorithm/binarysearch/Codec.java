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

/**
 * @author Sheldon Shao xshao@ebay.com on 3/25/18.
 * @version 1.0
 */

import leetcode.sheldon.algorithm.tree.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }

    //DFS preorder
    private StringBuilder serialize(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return sb;
        }
        sb.append(root.val).append(',');

        //LEFT
        if (root.left != null) {
            sb = serialize(sb, root.left);
        }
        else {
            sb.append('[');
        }
        if (root.right != null) {
            sb = serialize(sb, root.right);
        }
        else {
            sb.append(']');
        }
        return sb;
    }

    private static final TreeNode UNKNOWN = new TreeNode(Integer.MIN_VALUE);

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        int len = data.length();
        int start = 0;
        char ch;
        int val;
        TreeNode cur = null;
        for(int i = 0; i < len; i ++) {
            ch = data.charAt(i);

            if (ch == ',') {
                if (start >= 0 && i > start) {
                    val = Integer.parseInt(data.substring(start, i));

                    TreeNode node = new TreeNode(val);
                    node.left = UNKNOWN;
                    node.right = UNKNOWN;
                    if (start == 0) {
                        root = node;
                    }
                    if (cur != null) {
                        if (cur.val > val) {
                            cur.left = node;
                        }
                        else {
                            cur.right = node;
                        }
                    }
                    stack.push(node);
                    cur = node;
                }
                else {
                    throw new IllegalArgumentException(", in wrong position:" + data + "@" + i);
                }
                start = i + 1;
            }
            else if (ch == '[' || ch == ']') {
                if (cur == null) {
                    throw new IllegalArgumentException("[ or ] in wrong position:" + data + "@" + i);
                }
                if (ch == '[') {
                    cur.left = null;
                }
                else {
                    cur.right = null;
                }
                while ((cur.left == null && cur.right == null) || (cur.left != UNKNOWN && cur.right != UNKNOWN)) {
                    //POP
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    cur = stack.peek();
                }
                start = i + 1;
            }
            else if (!(ch >= '0' && ch <= '9')) {
                throw new IllegalArgumentException("Invalid data:" + data + "@" + i);
            }
        }
        return root;
    }
}