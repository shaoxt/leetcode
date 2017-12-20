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
package leetcode.sheldon.algorithm.integer;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * @author Sheldon Shao xshao@ebay.com on 12/19/17.
 * @version 1.0
 */
public class RomanToInteger {

    //I	1 V	5 X	10 L 50	C100	D500 M1000
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        char ch = 0;
        char pre = 0;
        for(int i = 0, len = s.length(); i < len; i ++) {
            pre = ch;
            ch = s.charAt(i);
            switch (ch) {
                case 'I':
                    sum ++;
                    break;
                case 'V':
                    if (pre == 'I') {
                        sum += 3;
                    }
                    else {
                        sum += 5;
                    }
                    break;
                case 'X':
                    if (pre == 'I') {
                        sum += 8;
                    }
                    else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    if (pre == 'I') {
                        sum += 48;
                    }
                    else if (pre == 'V') {
                        sum += 40;
                    }
                    else if (pre == 'X') {
                        sum += 30;
                    }
                    else {
                        sum += 50;
                    }
                    break;
                case 'C':
                    if (pre == 'I') {
                        sum += 98;
                    }
                    else if (pre == 'V') {
                        sum += 90;
                    }
                    else if (pre == 'X') {
                        sum += 80;
                    }
                    else {
                        sum += 100;
                    }
                    break;
                case 'D':
                    if (pre == 'I') {
                        sum += 498;
                    }
                    else if (pre == 'V') {
                        sum += 490;
                    }
                    else if (pre == 'X') {
                        sum += 480;
                    }
                    else if (pre == 'C') {
                        sum += 300;
                    }
                    else {
                        sum += 500;
                    }
                    break;
                case 'M':
                    if (pre == 'I') {
                        sum += 998;
                    }
                    else if (pre == 'V') {
                        sum += 990;
                    }
                    else if (pre == 'X') {
                        sum += 980;
                    }
                    else if (pre == 'C') {
                        sum += 800;
                    }
                    else {
                        sum += 1000;
                    }
                    break;
            }
        }
        return sum;
    }
}
