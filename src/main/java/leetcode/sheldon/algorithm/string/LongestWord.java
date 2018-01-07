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

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/5/18.
 * @version 1.0
 */
public class LongestWord {
    public String longestWord(String[] words) {
        int size = words.length;
        Set<String> set = new HashSet<>();
        boolean[] hasWords = new boolean[26];
        char firstChar;
        int index = 0;
        for(String word: words) {
            firstChar = word.charAt(0);
            if (word.length() == 1) {
                hasWords[firstChar-'a'] = true;
            }
            set.add(word);
        }
        String longestWord = null;
        int maxLen = 0;
        loop: for(String word: set) {
            firstChar = word.charAt(0);
            if (hasWords[firstChar-'a']) {
                int len = word.length();
                if (len >= maxLen) {
                    for(int i = len-1; i > 1; i --) {
                        if (!set.contains(word.substring(0, i))) {
                            continue loop;
                        }
                    }
                    if (len > maxLen || word.compareTo(longestWord) < 0) {
                        longestWord = word;
                    }
                    maxLen = len;
                }
            }
        }
        return longestWord;
    }
}
