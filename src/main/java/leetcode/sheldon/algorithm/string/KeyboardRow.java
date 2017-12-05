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
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 *
 American keyboard


 Example 1:
 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]
 Note:
 You may use one character in the keyboard more than once.
 You may assume the input string will only contain letters of alphabet.

 * @author Sheldon Shao xshao@ebay.com on 12/4/17.
 * @version 1.0
 */
public class KeyboardRow {

    private static final int[] ROWS =
                     // A B C D E F G
                     // H I J K L M N
                     // O P Q R S T
                     // U V W X Y Z
            new int[]{  1, 2, 2, 1, 0, 1, 1,
                        1, 0, 1, 1, 1, 2, 2,
                        0, 0, 0, 0, 1, 0,
                        0, 2, 0, 2, 0, 2 };

    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }
        List<String> result = new ArrayList<>(words.length);
        for (String word : words) {
            if (isInOneRow(word)) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    private boolean isInOneRow(String word) {
        int len = word.length();
        if (len == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int row = getRow(word.charAt(0));
        for(int i = 1; i < len; i ++) {
            if (row != getRow(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private int getRow(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return ROWS[ch - 'A'];
        }
        else if (ch >= 'a' && ch <= 'z') {
            return ROWS[ch - 'a'];
        }
        else {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
