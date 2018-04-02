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

import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 *
 *
 * You may assume each number in the sequence is unique.
 *
 * Follow up:
 *
 * Could you do it using only constant space complexity?
 *
 * @author Sheldon Shao xshao@ebay.com on 3/31/18.
 * @version 1.0
 */
public class VerifyPreorderQequenceInBinarySearchTree {

    public boolean verifyPreorder(int[] preorder) {
        return preorder == null || preorder.length == 0 || verifyPreorder(preorder, 0, preorder.length);
    }

    private boolean verifyPreorder(int[] preorder, int start, int end) {
        int prev = preorder[start];
        int leftBranchEnd = end; //Included;
        int i = start + 1;
        int curr;
        for(; i < end; i ++) {
            if (preorder[i] < prev) {
                prev = preorder[i];
            }
            else {
                leftBranchEnd = i-1;
                curr = preorder[i];
                break;
            }
        }

        if (leftBranchEnd < end) { //Use the left branch as stack
            int j = leftBranchEnd; //From

            for(; j >= start; j--) {
                int min = prev;
                int rightTreeStart = i;
                int max = j > start ? preorder[j-1] : Integer.MAX_VALUE;
                for(; i < end;i++) { //Find the right side nodes
                    curr = preorder[i];
                    if (curr <= min) {
                        return false;
                    }
                    else if (curr > max) {
                        if (!verifyPreorder(preorder, rightTreeStart, i+1)) {
                            return false;
                        }
                        break;
                        //Move to next tree
                    }
                }
                if (i == end && rightTreeStart < end) {
                    if (!verifyPreorder(preorder, rightTreeStart, end)) {
                        return false;
                    }
                    break;
                }
                prev = max;
            }
        }
        return true;
    }
}
