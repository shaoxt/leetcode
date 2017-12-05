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
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.

 * @author Sheldon Shao xshao@ebay.com on 12/4/17.
 * @version 1.0
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int start = 0;
        StringBuilder sb = new StringBuilder(len);
        char ch;
        for(int i = 0; i < len; i ++) {
            ch = s.charAt(i);
            if (ch == ' ') {
                for(int j = i - 1; j >= start; j --) {
                    sb.append(s.charAt(j));
                }
                sb.append(ch);
                start = i + 1;
            }
        }
        if (start < len) {
            for(int j = len - 1; j >= start; j --) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
}
