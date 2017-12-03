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
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING",
 * 3) should return "PAHNAPLSIIGYIR".
 *
 * @author Sheldon Shao xshao@ebay.com on 12/2/17.
 * @version 1.0
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (numRows <= 0) {
            throw new IllegalArgumentException("Illegal row number:" + numRows);
        }
        else if (numRows == 1) {
            return s;
        }

        int len = s.length();
        int mod = numRows*2-2;
        int group = len / mod;
        int lastGroupSize = len % mod;
        StringBuilder sb = new StringBuilder(len);

        for (int r = 0; r < numRows; r++) {
            for (int i = 0; i < group; i++) { //First Group
                int t = i * mod;
                sb.append(s, t + r, t + r + 1);
                if (r > 0 && r < numRows-1) {
                    sb.append(s, t + mod - r, t + mod - r + 1);
                }
            }
            if (lastGroupSize > r) { //2
                int t = group * mod;
                sb.append(s, t + r, t + r + 1);
                if (lastGroupSize > mod-r && r > 0 && r < numRows-1) {
                    sb.append(s, t + mod - r, t + mod - r + 1);
                }
            }
        }
        return sb.toString();
    }

        /*

          A      0 6
          B     157
          CE     24810
          D      3 9
         */

}
