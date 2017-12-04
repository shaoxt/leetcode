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

import java.util.ArrayList;
import java.util.List;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 *
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 *
 * @author Sheldon Shao xshao@ebay.com on 12/2/17.
 * @version 1.0
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int strLen = s.length();
        int patLen = p.length();
        if (p.indexOf('*') >= 0) {//Has star
            return isMatch(s, 0, strLen, p, 0, patLen);
        }
        else {//Match one by one
            if (strLen != patLen) {
                return false;
            }
            char strChar, patChar;
            for(int i = 0; i < strLen; i ++) {
                strChar = s.charAt(i);
                patChar = p.charAt(i);
                if (strChar != patChar && patChar != '.') {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean isMatch(String s, int sIndex, int sLen, String p, int pIndex, int pLen) {
        if (pLen == 0) {
            return sLen == 0;
        }
        char pChar = p.charAt(pIndex);
        boolean firstMatch = (sLen > 0 && (pChar == s.charAt(sIndex) || pChar == '.'));
        if (pLen >= 2 && p.charAt(pIndex+1) == '*'){
            return (isMatch(s, sIndex, sLen, p, pIndex + 2, pLen-2) ||
                    (firstMatch && isMatch(s, sIndex+1, sLen-1, p, pIndex, pLen)));
        } else {
            return firstMatch && isMatch(s, sIndex+1, sLen-1, p, pIndex+1, pLen-1);
        }
    }
}
