package leetcode.sheldon.contest.jan06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/6/18.
 * @version 1.0
 */
public class Contest3Test {
    @Test
    public void employeeFreeTime() throws Exception {
        Contest3 contest3 = new Contest3();

//        List<Contest3.Interval> list1 = new ArrayList<>();
//        list1.add(new Contest3.Interval(1, 2));
//        list1.add(new Contest3.Interval(5, 6));
//
//        List<List<Contest3.Interval>> avails = new ArrayList<>();
//        avails.add(list1);
//        List<Contest3.Interval> list2 = new ArrayList<>();
//        list2.add(new Contest3.Interval(3, 3));
//        avails.add(list2);
//
//        List<Contest3.Interval> list3 = new ArrayList<>();
//        list3.add(new Contest3.Interval(4, 10));
//        avails.add(list3);
//
//        System.out.println(contest3.employeeFreeTime(avails));


        List<Contest3.Interval> list1 = new ArrayList<>();
        list1.add(new Contest3.Interval(1, 3));
        list1.add(new Contest3.Interval(6, 7));

        List<List<Contest3.Interval>> avails = new ArrayList<>();
        avails.add(list1);
        List<Contest3.Interval> list2 = new ArrayList<>();
        list2.add(new Contest3.Interval(2, 4));
        avails.add(list2);

        List<Contest3.Interval> list3 = new ArrayList<>();
        list3.add(new Contest3.Interval(2, 5));
        list3.add(new Contest3.Interval(9, 12));
        avails.add(list3);

        System.out.println(contest3.employeeFreeTime(avails));
    }

}