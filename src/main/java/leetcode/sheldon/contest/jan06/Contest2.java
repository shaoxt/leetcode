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
package leetcode.sheldon.contest.jan06;

import java.util.HashSet;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/6/18.
 * @version 1.0
 */
public class Contest2 {
    public String boldWords(String[] words, String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        int len = S.length();
        HashSet<Character> firstChar = new HashSet<>();
        for(String w: words) {
            firstChar.add(w.charAt(0));
        }
        StringBuilder sb = new StringBuilder();
        char ch;
        boolean inBold = false;
        int[] lastBold = new int[1];
        for(int i = 0; i < len; i ++) {
            ch = S.charAt(i);
            if (inBold) {
                if (firstChar.contains(ch) && match(words, S, i, lastBold)) {
                    sb.append(ch);
                }
                else {
                    if (i < lastBold[0]) { //Until lastBold[0]
                        sb.append(ch);
                    }
                    else {
                        sb.append("</b>");
                        inBold = false;
                        sb.append(ch);
                    }
                }
            }
            else {
                if (firstChar.contains(ch) && match(words, S, i, lastBold)) {
                    inBold = true;
                    sb.append("<b>");
                    sb.append(ch);
                }
                else {
                    sb.append(ch);
                }
            }
        }
        if (inBold) {
            sb.append("</b>");
        }
        return sb.toString();
    }

    private boolean match(String[] words, String str, int start, int[] lastBold) {
        int maxLen = lastBold[0]-start;
        for(String w: words) {
            if (str.regionMatches(start, w, 0, w.length())) {
                maxLen = Math.max(w.length(), maxLen);
                lastBold[0] = start + maxLen;
            }
        }
        return maxLen > 0;
    }
}
