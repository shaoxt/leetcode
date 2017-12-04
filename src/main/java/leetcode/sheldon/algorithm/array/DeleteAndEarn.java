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
package leetcode.sheldon.algorithm.array;

import java.util.TreeMap;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/2/17.
 * @version 1.0
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n;
        for(int i = 0; i < len; i ++) {
            n = nums[i];
            map.put(n, map.getOrDefault(n, 0)+n);
        }

        int pre = 0, cur = 0;
        for(Integer k: map.keySet()) {
            n = map.get(k);
            if (!map.containsKey(k-1)) {
                pre = cur;
                cur += n;
            }
            else { //Close
                int temp = Math.max(pre + n, cur);
                pre = cur;
                cur = temp;
            }
        }
        return Math.max(cur, pre);
    }
}
