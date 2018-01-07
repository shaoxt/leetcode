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
package leetcode.sheldon.contest.dec30;

import java.util.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/30/17.
 * @version 1.0
 */
public class Contest4 {
//
//    public int intersectionSizeTwo(int[][] intervals) {
//        int min = 0;
//        int max = Integer.MAX_VALUE;
//        int len = intervals.length;
//        for(int i = 0; i < len; i ++) {
//            min = Math.min(intervals[i][0], min);
//            max = Math.max(intervals[i][1], max);
//        }
//
//        TreeMap<Integer, int[]> ranges = new TreeMap<>();
//        ranges.put(intervals[0][0], new int[] {intervals[0][1], 1});
//        for(int i = 1; i < len; i ++) {
//            putCommon(ranges, intervals[i]);
//        }
//
//        return 0;
//    }

//    protected void putCommon( TreeMap<Integer, int[]> ranges, int[] interval) {
//        int s = interval[0];
//        int e = interval[1];
//        Iterator<Integer> it = ranges.keySet().iterator();
//
//        int k;
//        while(it.hasNext()) {
//            k = it.next();
//            if (s < k) {
//                ranges.put(s, new int[] { k-1, 1}); //One time
//                int[] end = ranges.get(k);
//                if (end[0] >= e) {
//                    end[1] ++; //More
//                }
//                else {
//
//                }
//                s = k;
//                break;
//            }
//        }
//        int[] end = ranges.get(k);
//        if (end[0] >= e) {
//            end[1] ++; //More
//        }
//        else {
//            s = end[0] + 1;
//            it = ranges.keySet().iterator();
//            while(it.hasNext()) {
//
//            }
//        }
//    }
}
