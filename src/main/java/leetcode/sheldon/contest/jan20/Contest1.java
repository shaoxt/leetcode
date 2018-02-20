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
package leetcode.sheldon.contest.jan20;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/20/18.
 * @version 1.0
 */
public class Contest1 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        for(int x = 0; x < M; x ++) {
            if (!isSame(matrix, x, 0, M, N)) {
                return false;
            }
        }
        for(int y = 1; y < N; y ++) {
            if (!isSame(matrix, 0, y, M, N)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSame(int[][] matrix, int x, int y, int M, int N) {
        int v = matrix[x][y];
        int min = Math.min(M-x, N-y);
        for(int i = 1; i < min; i ++) {
            if (matrix[x + i][y + i] != v) {
                return false;
            }
        }
        return true;
    }
}
