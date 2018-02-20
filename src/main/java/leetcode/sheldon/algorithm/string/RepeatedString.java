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
 * @author Sheldon Shao xshao@ebay.com on 1/21/18.
 * @version 1.0
 */
public class RepeatedString {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len <= 1) {
            return false;
        }

        char[] array = s.toCharArray();
        int end = 1;
        char first = array[0];
        char ch;
        boolean toMatch = false;
        int j = 1;
        for(int i = 1; i < len; i ++) {
            if (toMatch || len % i == 0) {
                ch = array[i];
                if (toMatch) {
                    if (ch == array[j]) {
                        if (j == end) {
                            j = 0;
                        } else {
                            j++;
                        }
                    } else { //mismatch
                        i = end + 1;
                        toMatch = false;
                    }
                } else {
                    if (ch == first) {
                        end = i - 1;
                        j = end == 0 ? 0 : 1;
                        toMatch = true;
                    }
                }
            }
        }
        return toMatch && j == 0;
    }
}
