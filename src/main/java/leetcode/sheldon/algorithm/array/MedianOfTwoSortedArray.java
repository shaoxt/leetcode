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
package leetcode.sheldon.algorithm.array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * @author Sheldon Shao xshao@ebay.com on 12/1/17.
 * @version 1.0
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            if (nums2 == null || nums2.length == 0) {
                throw new IllegalArgumentException("Unexpected inputs");
            }
            return findMedian(nums2);
        }
        else if (nums2 == null || nums2.length == 0) {
            return findMedian(nums1);
        }

        int total = nums1.length + nums2.length;
        int half = total/2;
        boolean even = total % 2 == 0;
        int e1 = nums1.length - 1;
        int e2 = nums2.length - 1;

        int i1 = nums1.length >>> 1;
//        while(false) {
//            int mid1 = nums1[i1];
//            int mid1InNum2 = binarySearch(nums2, 0, nums2.length, mid1);
//            if (mid1InNum2 == -1) { //All large than
//
//            }
//            else if (mid1InNum2 == - nums2.length) {
//
//            }
//            int dist;
//            if (mid1InNum2 < 0) {
//                mid1InNum2 = -mid1InNum2;
//            }
//            dist = i1 + mid1InNum2 - (e1 - i1 + e2 - mid1InNum2);
//            if (dist == 0 || Math.abs(dist) == 1) {
//                return mid1;
//            } else {
//                i1 -= dist >>> 1;
//            }
//        }

        return 0;
    }

    private int binarySearch(int[] nums, int low, int high, int v) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal < v) {
                low = mid + 1;
            }
            else if (midVal > v) {
                high = mid - 1;
            }
            else {
                return mid; // key found
            }
        }
        return -(low + 1);  // key not found.
    }

    private double findMedian(int[] nums) {
        int mid = nums.length >>> 1;
        if (nums.length % 2 == 1) {
            return nums[mid];
        }
        else {
            return (nums[mid-1] + nums[mid]) >>> 1;
        }
    }
}
