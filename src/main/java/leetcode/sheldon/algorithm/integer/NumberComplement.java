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
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 Note:
 The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 You could assume no leading zero bit in the integer’s binary representation.
 Example 1:
 Input: 5
 Output: 2
 Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 Example 2:
 Input: 1
 Output: 0
 Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.


 * @author Sheldon Shao xshao@ebay.com on 12/4/17.
 * @version 1.0
 */
public class NumberComplement {
    public int findComplement(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("It should be a positive integer:" + num);
        }
        int n = num;
        int mask = 0;
        while(n > 0) {
            mask = (mask << 1) | 1;
            n = n >>> 1;
        }
        return mask ^ num;
    }
}
