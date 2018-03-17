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
 * @author Sheldon Shao xshao@ebay.com on 3/17/18.
 * @version 1.0
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        else if (n < 0) {
            throw new IllegalArgumentException("Unsupported number:" + n);
        }
        else if (n == 1) {
            return "1";
        }
        /*
       1.     1
       2.     11
       3.     21
       4.     1211
       5.     111221
       6.     3122111
       7.     13112221
       8.     1113213211
       9.     31131211131221
    */
        StringBuilder src = new StringBuilder(n*2);
        src.append('1');
        int count;
        char pre, cur = 0;
        int len;
        StringBuilder out = new StringBuilder(n*2);
        for(int i = 1; i < n; i ++) {
            len = src.length();
            pre = src.charAt(0);
            count = 1;
            for(int j = 1; j < len; j ++) {
                cur = src.charAt(j);
                if (pre == cur) {
                    count ++;
                }
                else {
                    out.append(pre).append(count);
                    count = 1;
                    pre = cur;
                }
            }
            if (len == 1 || pre == cur) {
                out.append(pre).append(count);
            }
            StringBuilder tmp = src;
            src = out;
            out = tmp;
            out.setLength(0); //Clear
        }
        return src.reverse().toString();
    }
}
