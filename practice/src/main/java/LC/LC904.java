package LC;

import interfaces.LeetCodeQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 *
 Code
 Testcase
 Testcase
 Test Result
 904. Fruit Into Baskets
 Solved
 Medium
 Topics
 Companies
 You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

 You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

 You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 Given the integer array fruits, return the maximum number of fruits you can pick.



 Example 1:

 Input: fruits = [1,2,1]
 Output: 3
 Explanation: We can pick from all 3 trees.
 Example 2:

 Input: fruits = [0,1,2,2]
 Output: 3
 Explanation: We can pick from trees [1,2,2].
 If we had started at the first tree, we would only pick from trees [0,1].
 Example 3:

 Input: fruits = [1,2,3,2,2]
 Output: 4
 Explanation: We can pick from trees [2,3,2,2].
 If we had started at the first tree, we would only pick from trees [1,2].


 Constraints:

 1 <= fruits.length <= 105
 0 <= fruits[i] < fruits.length
 */
public class LC904 implements LeetCodeQuestion {
    @Override
    public void solution() {
        int[] fruits = new int[]{1,2,3,4,1};
        int result = totalFruit(fruits);
        System.out.println(result);
    }
    public int totalFruit(int[] fruits) {
        int res = 0;
        int curCount = 0;
        int n = fruits.length;

        int start = 0, end = 0;
        Map<Integer, Integer>  curSet = new HashMap<>();
        while (end < n) {
            int cur = fruits[end];
            curSet.put(cur, curSet.getOrDefault(cur, 0) + 1);
            curCount++;

            while (curSet.size() > 2) {
                curSet.put(fruits[start], curSet.get(fruits[start])-1);
                if (curSet.get(fruits[start]) == 0) {
                    curSet.remove(fruits[start]);
                }
                start++;
                curCount--;
            }
            end++;

            res = Math.max(res, curCount);

        }
        return res;
    }
}
