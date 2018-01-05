package leetcode.sheldon.contest.dec23;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 12/23/17.
 * @version 1.0
 */
public class Contest2Test {
    @Test
    public void ipToCIDR() throws Exception {
        Contest2 contest2 = new Contest2();

        System.out.println(contest2.ipToCIDR("255.0.0.7", 10));

        System.out.println(contest2.ipToCIDR("117.145.102.62", 8));

//        Output:
//["117.145.102.62/31","117.145.102.64/29"]
//        Expected:
//["117.145.102.62/31","117.145.102.64/30","117.145.102.68/31"]
    }

}