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
 * @author Sheldon Shao xshao@ebay.com on 12/8/17.
 * @version 1.0
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        int preCount = 0;
        int curCount = 1;
        int count = 0;
        char pre = s.charAt(0), cur;
        for(int i = 1; i < len; i ++) {
            cur = s.charAt(i);
            if (pre != cur) {
                count += Math.min(preCount, curCount);
                preCount = curCount;
                curCount = 1;
                pre = cur;
            }
            else {
                curCount ++;
            }
        }
        count += Math.min(preCount, curCount);
        return count;
    }
}
