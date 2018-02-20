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
package leetcode.sheldon.contest.jan13;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/13/18.
 * @version 1.0
 */
public class Contest1 {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> prime = new HashSet<>();
        prime.add(2);
        prime.add(3);
        prime.add(5);
        prime.add(7);
        prime.add(11);
        prime.add(13);
        prime.add(17);
        prime.add(19);
        prime.add(23);
        prime.add(29);
        prime.add(31);
        int count = 0;
        int c;
        for(int i = L; i <= R; i ++) {
            c = bitCount(i);
            if (prime.contains(c)) {
                count ++;
            }
        }
        return count;
    }

    private int bitCount(int n) {
        int bits = 0;
        while(n > 0) {
            bits += (n & 0x01);
            n = n >> 1;
        }
        return bits;
    }
}
