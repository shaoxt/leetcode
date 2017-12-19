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
package leetcode.sheldon.contest.dec16;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/16/17.
 * @version 1.0
 */
public class Contest3 {
    public int countCornerRectangles(int[][] grid) {
        int maxX = grid.length;
        int maxY = grid[0].length;
        int endX = maxX - 1;
        int endY = maxY - 1;
        int count = 0;
        for(int i = 0; i < endX; i ++) {
            for(int j = 0; j < endY; j ++) {
                count += countCornerRectangles(grid, i, j, maxX, maxY);
            }
        }
        return count;
    }

    public int countCornerRectangles(int[][] grid, int x, int y, int maxX, int maxY) {
        int count = 0;
        if (grid[x][y] == 1) {
            for (int i = x + 1; i < maxX; i++) {
                if (grid[i][y] == 1) {
                    for (int j = y + 1; j < maxY; j++) {
                        if (grid[x][j] == 1 && grid[i][j] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
