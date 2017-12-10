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
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.

 * @author Sheldon Shao xshao@ebay.com on 12/9/17.
 * @version 1.0
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        int sum = a;
        int left = b;
        int tmp;
        while(left != 0) {
            tmp = sum;
            sum = sum ^ left;
            left = (tmp & left) << 1;
        }
        return sum;
    }

    public int getSubtract(int a, int b) {
        int tmp = getSum(~b, 1);
        return getSum(a, tmp);
    }

    public int getMultiply(int a, int b) {
        if (b == 0 || a == 0) {
            return 0;
        }

        boolean negative = !((b > 0 && a > 0) || (b < 0 && a < 0));
        a = a < 0 ? getSum(~a, 1) : a;
        b = b < 0 ? getSum(~b, 1) : b;

        int multiply = 0;
        int v;
        int bit = 0;
        while (b > 0) {
            v = b & 1;
            if (v == 1) {
                multiply = getSum(a<<bit, multiply);
            }
            b = b >> 1;
            bit = getSum(bit, 1);
        }
        return !negative ? multiply : getSum(~multiply, 1);
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Can't divide by zero");
        }
        if (a == 0) {
            return 0;
        }
        boolean negative = !((b > 0 && a > 0) || (b < 0 && a < 0));
        a = a < 0 ? getSum(~a, 1) : a;
        b = b < 0 ? getSum(~b, 1) : b;
        if (a < b) {
            return 0; //
        }
        else if (a == b) {
            return negative ? getSum(~1, 1) : 1;
        }

        int dividend = a;
        int divisor = b;
        int bit = 0;
        while(dividend >= divisor) {
            dividend = dividend >> 1;
            bit = getSum(bit, 1);
        }

        dividend = a;
        int result = 0;
        int tmp;
        for(int i = bit-1; i >= 0;i --) {
            tmp = b<<i;
            if (dividend >= tmp) {
                dividend = getSum(dividend, getSum(~tmp, 1));
                result = getSum(result, 1<<i);
            }
        }
        return negative ? getSum(~result, 1) : result;
    }
}
