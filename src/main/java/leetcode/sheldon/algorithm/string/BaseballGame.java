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
package leetcode.sheldon.algorithm.string;

import java.util.Stack;

/**
 * You're now a baseball game point recorder.

 Given a list of strings, each string can be one of the 4 following types:

 Integer (one round's score): Directly represents the number of points you get in this round.
 "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 Each round's operation is permanent and could have an impact on the round before and the round after.

 You need to return the sum of the points you could get in all the rounds.

 Example 1:
 Input: ["5","2","C","D","+"]
 Output: 30
 Explanation:
 Round 1: You could get 5 points. The sum is: 5.
 Round 2: You could get 2 points. The sum is: 7.
 Operation 1: The round 2's data was invalid. The sum is: 5.
 Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 Example 2:
 Input: ["5","-2","4","C","D","9","+","+"]
 Output: 27
 Explanation:
 Round 1: You could get 5 points. The sum is: 5.
 Round 2: You could get -2 points. The sum is: 3.
 Round 3: You could get 4 points. The sum is: 7.
 Operation 1: The round 3's data is invalid. The sum is: 3.
 Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
 Round 5: You could get 9 points. The sum is: 8.
 Round 6: You could get -4 + 9 = 5 points. The sum is 13.
 Round 7: You could get 9 + 5 = 14 points. The sum is 27.
 Note:
 The size of the input list will be between 1 and 1000.
 Every integer represented in the list will be between -30000 and 30000.

 * @author Sheldon Shao xshao@ebay.com on 12/4/17.
 * @version 1.0
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        int len = ops.length;
        String str;
        int currentScore = 0;
        int sum = 0;
        Stack<Integer> stacks = new Stack<>();
        for(int i = 0; i < len; i ++) {
            str = ops[i];
            if ("C".equals(str)) {
                if (!stacks.isEmpty()) {
                    Integer last = stacks.pop();
                    sum -= last;
                }
                else {
                    throw new IllegalArgumentException("Unexpected C in index:" + i);
                }
            }
            else {
                if ("D".equals(str)) {
                    if (stacks.isEmpty()) {
                        throw new IllegalArgumentException("Unexpected D in index:" + i);
                    }
                    currentScore = stacks.peek() * 2;
                }
                else if ("+".equals(str)) {
                    int size = stacks.size();
                    if (size < 2) {
                        throw new IllegalArgumentException("Unexpected + in index:" + i);
                    }
                    currentScore = stacks.peek() + stacks.get(size - 2);
                }
                else {
                    //Suppose it is integer
                    try {
                        currentScore = Integer.parseInt(str);
                    }
                    catch(Exception ex) {
                        throw new IllegalArgumentException("Invalid score:" + str);
                    }
                }
                sum += currentScore;
                stacks.push(currentScore);
            }
        }
        return sum;
    }
}
