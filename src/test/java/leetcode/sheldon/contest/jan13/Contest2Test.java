package leetcode.sheldon.contest.jan13;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/13/18.
 * @version 1.0
 */
public class Contest2Test {

    @Test
    public void test() {
        Contest2 contest2 = new Contest2();
        System.out.println(contest2.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(contest2.partitionLabels("ababcbacadefegdehijhklijs"));
        System.out.println(contest2.partitionLabels("ababcbacasdefegdehijhklij"));
        System.out.println(contest2.partitionLabels("ababcbacasdefegdehijhklisj"));
        System.out.println(contest2.partitionLabels("ababcbacadefegdehijhklisj"));
        System.out.println(contest2.partitionLabels("ababcbacasdefegdehijhklia"));
    }
}