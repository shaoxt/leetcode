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

/**
 * @author Sheldon Shao xshao@ebay.com on 12/30/17.
 * @version 1.0
 */
public class Contest1 {

    public int reachNumber(int target) {
        if (target < 0) {
            target = - target;
        }
        int start = (int)Math.sqrt(target);
        int t = (start + 1) * (start) / 2;
        int end = start + 1;
        int next = (end + 1) * (end) / 2;
        while(next < target) {
            start = end;
            t = next;
            end ++;
            next = (end + 1) * (end) / 2;

        }
        if (next == target) {
            return end;
        }
        else if (next - target < target - t){ //Use next

            return end + (next - target) * 2;
        }
        else { //use t

            return start + (target - t) * 2;
        }
    }

}
