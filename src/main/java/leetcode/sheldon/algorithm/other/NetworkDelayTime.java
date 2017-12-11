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
package leetcode.sheldon.algorithm.other;

import java.util.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/9/17.
 * @version 1.0
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        int len = times.length;
        int[] array;
        for(int i = 0; i < len; i ++) {
            array = times[i];
            Map<Integer, Integer> map = cache.getOrDefault(array[0], new HashMap<>());
            map.put(array[1], array[2]);
            cache.put(array[0], map);
        }
        int[] delay = new int[N+1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        delay[K] = 0;
        Set<Integer> travel = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(K);
        while(!queue.isEmpty()) {
            travel.clear();
            Integer u = queue.poll();
            Map<Integer, Integer> result = cache.get(u);
            if (result != null) {
                for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                    Integer k = entry.getKey();
                    int v = entry.getValue();
                    if (delay[u] + v < delay[k]) {
                        if (!travel.contains(k)) {
                            queue.offer(k);
                            travel.add(k);
                        }
                        delay[k] = delay[u] + v;
                    }
                }
            }
        }
        int maxDelay = 0;
        for (int i = 1; i <= N; i++) {
            maxDelay = Math.max(maxDelay, delay[i]);
        }
        return maxDelay == Integer.MAX_VALUE ? -1 : maxDelay;
    }
}
