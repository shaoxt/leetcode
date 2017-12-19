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

import java.util.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/16/17.
 * @version 1.0
 */
public class Contest2 {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        List<String> list = new ArrayList<>();
        for(int i = 0; i < words.length; i ++) {
            list.add(words[i]);
        }

        char ch;
        int len = licensePlate.length();

        char ch1, ch2;
        String str;
        Map<String, boolean[]> map = new HashMap<>();
        for(int i = 0; i < len; i ++) {
            ch = licensePlate.charAt(i);
            if (Character.isLetter(ch)) {
                ch1 = Character.toUpperCase(ch);
                ch2 = Character.toLowerCase(ch);

                int index1, index2;
                for(int j = list.size()-1; j >= 0; j --) {
                    str = list.get(j);
                    index1 = str.indexOf(ch1);
                    index2 = str.indexOf(ch2);
                    if (index1 < 0 && index2 < 0) {
                        list.remove(j);
                    }
                    boolean[] bits = map.getOrDefault(str, new boolean[str.length()]);

                    int index = index1 >= 0 ? index1 : index2;
                    while(index >= 0) {
                        if (!bits[index]) {
                            bits[index] = true;
                            break;
                        }
                        index1 = str.indexOf(ch1, index+1);
                        index2 = str.indexOf(ch2, index+1);
                        index = index1 >= 0 ? index1 : index2;
                        if (index < 0) {
                            list.remove(j);
                            break;
                        }
                    }
                    map.put(str, bits);
                }
            }
        }

        if (list.size() > 0) {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < list.size(); i ++) {
                min = Math.min(min, list.get(i).length());
            }
            for(int i = 0; i < list.size(); i ++) {
                if (list.get(i).length() == min) {
                    return list.get(i);
                }
            }
            return list.get(0);
        }
        else {
            return list.isEmpty() ? null : list.get(0);
        }
    }
}
