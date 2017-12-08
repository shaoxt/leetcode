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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

 Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

 Example 1:
 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 Example 2:
 [[0,0,0,0,0,0,0,0]]
 Given the above grid, return 0.
 Note: The length of each dimension in the given grid does not exceed 50.

 * @author Sheldon Shao xshao@ebay.com on 12/7/17.
 * @version 1.0
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len1 = grid.length;
        int len2 = grid[0].length;
        int[] row;
        int cur;
        int pre;
        for(int i = 0; i < len1; i ++) {
            row = grid[i];
            for(int j = 0; j < len2; j ++) {
                if (row[j] == 1) {
                    cur = ((i << 8) | j);
                    pre = j > 0 ? ((i << 8) | (j-1)) : -1;
                    List<Integer> list = pre >= 0 ? map.get(pre) : null;
                    if (list == null) {
                        list = new ArrayList<Integer>();
                    }
                    list.add(cur);
                    map.put(cur, list);
                }
            }
        }
        for(int j = 0; j < len2; j ++) {
            for(int i = 0; i < len1; i ++) {
                if (grid[i][j] == 1) {
                    cur = (i << 8 | j);
                    pre = i > 0 ? (((i-1) << 8) | j) : -1;
                    List<Integer> list1 = pre >= 0 ? map.get(pre) : null;
                    if (list1 == null) {
                        continue;
                    }
                    List<Integer> list2 = map.get(cur);
                    if (list1 != list2) {
                        List<Integer> newList = new ArrayList(list1.size() + list2.size());
                        newList.addAll(list1);
                        newList.addAll(list2);
                        for (int k = 0; k < newList.size(); k++) {
                            map.put(newList.get(k), newList);
                        }
                    }
                }
            }
        }
        int max = 0;
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            max = Math.max(max, entry.getValue().size());
        }
        return max;
    }
}
