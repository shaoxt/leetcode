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
 * @author Sheldon Shao xshao@ebay.com on 3/17/18.
 * @version 1.0
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        if (n == 0) { // 0!=1
            return 0;
        }
        else if (n < 0) {
            throw new IllegalArgumentException("Unsupported negative number for now:" + n);
        }
        // n * (n-1) * (n-2) * ... * 1
        // 5  10  15 20  25 30... 80 85 90 95 100  105
        // 1  1   1  1   1  1     20 21 22 23 25   26

        // [100 - 1000)
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

}
