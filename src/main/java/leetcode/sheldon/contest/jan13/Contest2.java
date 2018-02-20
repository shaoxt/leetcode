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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/13/18.
 * @version 1.0
 */
public class Contest2 {

    public List<Integer> partitionLabels(String S) {
        int[][] array = new int[26][];

        int len = S.length();
        char ch;
        int index;
        for(int i = 0; i < len; i ++) {
            ch = S.charAt(i);
            index = ch - 'a';
            if (array[index] == null) { //Has already marked
                array[index] = new int[] {i, -1};
            }
            else { //Set second position
                array[index][1] = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        int i = 0;
        int[] range;
        int max = -1;
        int start = 0;
        while(i < len) {
            ch = S.charAt(i); //First
            range = array[ch - 'a'];
            if (range[1] == -1) { //Not in another place
                if (max == -1) {
                    list.add(1);
                    start = i + 1;
                }
            }
            else {
                max = Math.max(max, range[1]);
            }
            if (i == max) {
                list.add(max - start + 1);
                start = i + 1;
                max = -1;
            }
            i ++;
        }

        return list;
    }

}
