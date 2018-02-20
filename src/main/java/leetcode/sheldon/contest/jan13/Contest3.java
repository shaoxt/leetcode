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

/**
 * @author Sheldon Shao xshao@ebay.com on 1/13/18.
 * @version 1.0
 */
public class Contest3 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        boolean odd = N%2 == 1;
        int half = N >> 1;
        int maxMax = half + (odd ? 1 : 0);
        if (mines.length == 0) {
            return maxMax;
        }
        int[][] grid = new int[N][N]; //Reverse 1 and 0
        for(int[] mine: mines) {
            grid[mine[0]][mine[1]] = 1;
        }

        int max = 0;
        int flag = 0; // 0 right 1 down 2 left 3 up
        int i = half - (odd ? 0 : 1);
        int j = half - (odd ? 0 : 1);

        int count = 0;
        int N2 = N * N;
        int repeat = 0;

        while(count < N2) {
            int m = Math.min(N-j, Math.min(N-i, Math.min(i+1, j+1)));
            if (m > max) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, 1);
                    m = maxPlusSign(grid, i, j, m, max, N);
                    max = Math.max(max, m);
                    if (max == maxMax) {
                        return maxMax;
                    }
                }
            }

            switch (flag) {
                case 0:
                    i ++;
                    break;
                case 1:
                    j ++;
                    break;
                case 2:
                    i --;
                    break;
                case 3:
                    j --;
                    break;
            }

            repeat ++;
            if (repeat >= (count >> 1) + 1) {
                repeat = 0;
                flag = (flag + 1) % 4; //Rolling
            }
            count ++;
        }
        return max;
    }

    public int maxPlusSign(int[][] grid, int x, int y, int m, int max, int N) {
        int startY = y - m;
        for(int j = y - 1; j > startY; j --) {
            if (grid[x][j] == 1) {
                m = Math.min(m, y - j);
                if (m <= max) {
                    return m;
                }
                break;
            }
        }

        int endY = y + m;
        for(int j = y + 1; j < endY; j ++) {
            if (grid[x][j] == 1) {
                m = Math.min(m, j - y);
                if (m <= max) {
                    return m;
                }
                break;
            }
        }
        int startX = x - m;
        for(int i = x - 1; i > startX; i --) {
            if (grid[i][y] == 1) {
                m = Math.min(m, x - i);
                if (m <= max) {
                    return m;
                }
                break;
            }
        }
        int endX = x + m;
        for(int i = x + 1; i < endX; i ++) {
            if (grid[i][y] == 1) {
                m = Math.min(m, i - x);
                if (m <= max) {
                    return m;
                }
                break;
            }
        }
        return m;
    }

}
