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
package leetcode.sheldon.contest.dec23;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/23/17.
 * @version 1.0
 */
public class Contest2 {

    public List<String> ipToCIDR(String ip, int range) {
        int value = strToIp(ip);
        int end = value + range;

        List<String> result = new ArrayList<>();

        int suffix = 32;
        int mask = 1;
        while(value < end) {
            int v = value & mask;
            if (v > 0) {
                result.add(ipToString(value) + "/" + suffix);
                value += mask;
                suffix = 32;
                mask = 1;
            }
            else {
                if (value + mask * 2 <= end) {
                    mask = mask << 1;
                    suffix--;
                }
                else {
                    result.add(ipToString(value) + "/" + suffix);
                    value += mask;
                    suffix = 32;
                    mask = 1;
                }
            }
        }
        return result;
    }


    public static int strToIp(String ip) {
        String[] array = ip.split("\\.");
        int value = (Integer.parseInt(array[0]) << 24) +
                (Integer.parseInt(array[1]) << 16) +
                (Integer.parseInt(array[2]) << 8)
                + (Integer.parseInt(array[3]));
        return value;
    }

    public static String ipToString(int value) {
        return String.valueOf((value >> 24) & 0xFF) + "." +
        String.valueOf((value >> 16) & 0xFF) + "." +
                String.valueOf((value >> 8) & 0xFF) + "." +
                String.valueOf(value & 0xFF);
    }
}
