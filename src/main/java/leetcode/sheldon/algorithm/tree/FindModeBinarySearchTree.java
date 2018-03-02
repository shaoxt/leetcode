package leetcode.sheldon.algorithm.tree;

import java.util.Arrays;

/**
 * @author Sheldon Shao xshao@ebay.com on 2/19/18.
 * @version 1.0
 */
public class FindModeBinarySearchTree {

    private int[] results;
    private int resultSize;
    private int curFreq = 0;
    private int maxFreq = 0;
    private Integer pre;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        dfs(root);
        if (resultSize > 0) {
            if (results.length == resultSize) {
                return results;
            }
            else {
                int[] newResults = new int[resultSize];
                System.arraycopy(results, 0, newResults, 0, resultSize);
                return newResults;
            }
        }
        else {
            return new int[0];
        }
    }

    private void addResults(int v) {
        if (results == null) {
            results = new int[] { v };
            resultSize = 1;
        }
        else {
            if (resultSize < results.length) {
                results[resultSize++] = v;
            }
            else {
                resultSize = results.length + 1;
                int[] newResults = new int[resultSize];
                System.arraycopy(results, 0, newResults, 0, results.length);
                newResults[results.length] = v;
                results = newResults;
            }
        }
    }

    private void setResults(int v) {
        if (results == null) {
            results = new int[] { v };
        }
        else {
            results[0] = v;
        }
        resultSize = 1;
    }

    private void dfs(TreeNode n) {
        if (n.left != null) {
            dfs(n.left);
        }

        if (pre == null || pre == n.val) {
            curFreq ++;
        }
        else {
            curFreq = 1;
        }
        if (curFreq >= maxFreq) {
            if (curFreq > maxFreq) {
                setResults(n.val);
                maxFreq = curFreq;
            }
            else {
                addResults(n.val);
            }
        }
        pre = n.val;

        if (n.right != null) {
            dfs(n.right);
        }
    }
}
