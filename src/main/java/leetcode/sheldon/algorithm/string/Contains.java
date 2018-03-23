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
 * @author Sheldon Shao xshao@ebay.com on 3/22/18.
 * @version 1.0
 */
public class Contains {


    public static boolean contains(String src, String target) {
        if (src == null || target == null) {
            return false;
        }

        int srcLen = src.length();
        int targetLen = target.length();
        if (srcLen < targetLen) {
            return false;
        }
        if (targetLen == 0) { //How can we decide a string contains empty string?
            return true;
        }
        char firstChar = target.charAt(0);
        int end = srcLen - targetLen + 1;
        for(int i = 0; i < end; i ++) {
            if (src.charAt(i) == firstChar) {
                int k = i + 1;
                int j = 1;
                for(; j < targetLen && k < srcLen; j ++, k ++) {
                    if (src.charAt(k) != target.charAt(j)) {
                        break;
                    }
                }
                if (j == targetLen) {
                    return true;
                }
            }
        }
        return false;
    }
}
