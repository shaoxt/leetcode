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
package leetcode.sheldon.algorithm.string;

/**
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

 A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

 The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

 Example 1:
 Input: "aba", "cdc"
 Output: 3
 Explanation: The longest uncommon subsequence is "aba" (or "cdc"),
 because "aba" is a subsequence of "aba",
 but not a subsequence of any other strings in the group of two strings.
 Note:

 Both strings' lengths will not exceed 100.
 Only letters from a ~ z will appear in input strings.
 *
 * @author Sheldon Shao xshao@ebay.com on 12/6/17.
 * @version 1.0
 */
public class LongestUncommonSubsequenceI {

    public int findLUSlength(String a, String b) {
        if (a == null || b == null) {
            return -1;
        }
        int len = a.length();
        if (!b.contains(a)) {
            return len;
        }
        int max = -1;
        for(int i = 0, j = len; i < len && j > 0; i ++, j --) {
            if (!b.contains(a.substring(i))) {
                max = len - i;
                break;
            }
            if (!b.contains(a.substring(0, j))) {
                max = j;
                break;
            }
        }
        return max;
    }
}
