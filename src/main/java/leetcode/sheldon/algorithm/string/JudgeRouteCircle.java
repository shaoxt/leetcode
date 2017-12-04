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
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

 The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

 Example 1:
 Input: "UD"
 Output: true
 Example 2:
 Input: "LL"
 Output: false

 * @author Sheldon Shao xshao@ebay.com on 12/3/17.
 * @version 1.0
 */
public class JudgeRouteCircle {

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        int len = moves.length();
        if (len == 1) {
            return false;
        }

        int x = 0, y = 0;
        char ch;
        for(int i = 0; i < len; i ++) {
            ch = moves.charAt(i);
            switch (ch) {
                case 'U':
                    y ++;
                    break;
                case 'D':
                    y --;
                    break;
                case 'L':
                    x --;
                    break;
                case 'R':
                    x ++;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command:" + ch);
            }
        }
        return x == 0 && y == 0;
    }
}
