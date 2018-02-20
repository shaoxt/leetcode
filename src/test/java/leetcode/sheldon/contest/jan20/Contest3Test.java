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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/20/18.
 * @version 1.0
 */
public class Contest3Test {
    @Test
    public void maxChunksToSorted() throws Exception {
        Contest3 contest3 = new Contest3();
        assertEquals(1, contest3.maxChunksToSorted(new int[] { 4, 3, 2, 1, 0}));
        assertEquals(4, contest3.maxChunksToSorted(new int[] { 1,0,2,3,4}));
        assertEquals(2, contest3.maxChunksToSorted(new int[] {0,4,2,3,1}));

        assertEquals(3, contest3.maxChunksToSorted(new int[] { 1,2,0,3,4}));
        assertEquals(2, contest3.maxChunksToSorted(new int[] {0,4,5,2,1,3}));


        assertEquals(1, contest3.maxChunksToSorted(new int[] {1,4,3,6,0,7,8,2,5}));

    }
}
