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
package leetcode.sheldon.contest.jan06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/6/18.
 * @version 1.0
 */
public class Contest3 {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        int size = avails.size();
        List<List<Interval>> freeTime = new ArrayList<>(size);
        for(int i = 0; i < size; i ++) {
            freeTime.add(convert(avails.get(i)));
        }
        return calcCommon(freeTime);
    }

    private List<Interval> calcCommon(List<List<Interval>> freeTime) {
        int size = freeTime.size();
        List<Interval> common = freeTime.get(0);
        for(int i = 1; i < size; i ++) {
            common = calcCommon(common, freeTime.get(i));
        }
        if (common.get(0).start == -1) {
            common.remove(0);
        }
        if (common.get(common.size()-1).end == Integer.MAX_VALUE) {
            common.remove(common.size()-1);
        }
        return common;
    }

    private List<Interval> calcCommon(List<Interval> first, List<Interval> seconds) {
        List<Interval> common = new ArrayList<>();
        int i = 0;
        int j = 0;
        int nextStart = 0;
        Interval firstInterval;
        firstInterval = first.get(0);
        Interval secondInterval = seconds.get(0);
        int firstEnd = first.size() - 1;
        int secondEnd = seconds.size() - 1;
        for(; i <= firstEnd || j <= secondEnd; ) {
            if (firstInterval.end <= secondInterval.start) { //No common
                if (i < firstEnd) {
                    firstInterval = first.get(++i);
                }
            }
            else if (secondInterval.end <= firstInterval.start) {
                if (j < secondEnd) {
                    secondInterval = seconds.get(++j);
                }
            }
            else {
                int maxStart = Math.max(firstInterval.start, secondInterval.start);
                int minEnd = Math.min(firstInterval.end, secondInterval.end);
                common.add(new Interval(maxStart, minEnd));
                if (minEnd == Integer.MAX_VALUE) {
                    break;
                }
                if (firstInterval.end == minEnd) {
                    if (i < firstEnd) {
                        firstInterval = first.get(++i);
                    }
                }
                else {
                    if (j < secondEnd) {
                        secondInterval = seconds.get(++j);
                    }
                }
            }
        }
        return common;
    }

    private List<Interval> convert(List<Interval> list) {
        List<Interval> freeTime = new ArrayList<>(list.size());
        Interval first = new Interval(-1, list.get(0).start);
        freeTime.add(first);
        int start = list.get(0).end;
        for(int i = 1; i < list.size(); i ++) {
            Interval interval = list.get(i);
            Interval next = new Interval(start, interval.start);
            freeTime.add(next);
            start = interval.end;
        }
        freeTime.add(new Interval(start, Integer.MAX_VALUE));
        return freeTime;
    }
}
