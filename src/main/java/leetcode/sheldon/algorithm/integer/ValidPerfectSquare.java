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
 * @author Sheldon Shao xshao@ebay.com on 1/16/18.
 * @version 1.0
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        else if (num == 0) {
            return true;
        }
        int bits = 0;
        int n = num;
        while(n > 0) {
            n = n >> 1;
            bits ++;
        }
        int halfBits = (bits >> 1) + (bits % 2 == 0 ? 0 : 1);
        int max = (1 << halfBits);
        int min = (1 << (halfBits - 1));

        int mid = (max + min) / 2;
        long power = (long)mid * mid;
        if (power == mid) {
            return true;
        }
        while(min <= max) {
            mid = (max + min) / 2;
            power = (long)mid * mid;
            if (power == num) {
                return true;
            }
            else if (power > num) {
                if (max == mid) {
                    break;
                }
                max = mid;
            }
            else {
                if (min == mid) {
                    break;
                }
                min = mid;
            }
        }
        return false;
    }
}
