package LC;

import interfaces.LeetCodeQuestion;
import java.util.stream.IntStream;

/**
 * Given two positive integers left and right, find the two integers num1 and num2 such that:
 *
 * left <= num1 < num2 <= right .
 * Both num1 and num2 are prime numbers.
 * num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
 * Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].
 *
 *
 *
 * Example 1:
 *
 * Input: left = 10, right = 19
 * Output: [11,13]
 * Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
 * The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
 * Since 11 is smaller than 17, we return the first pair.
 * Example 2:
 *
 * Input: left = 4, right = 6
 * Output: [-1,-1]
 * Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
 */

public class LC2523 implements LeetCodeQuestion {

    @Override
    public void solution() {
        int left = 1, right = 100;
        int[] res = closestPrimes(left, right);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] closestPrimes(int left, int right) {

        int[] result = new int[2];
        int minDif = right;
        result[0] = -1;
        result[1] = -1;

        boolean[] sieves = new boolean[right+1];
        IntStream.range(2, right+1).forEach(i -> sieves[i]=true);

        for (int i=2;(i*i) <= right;i++) {
            if (!sieves[i]) {
                continue;
            }
            for (int j=i*2;j <=right; j=j+i) {
                sieves[j] = false;
            }
        }


        int current = right;

        while (current > left) {

            if (!sieves[current] && current > left) {
                current--;
                continue;
            }

            int curLeft = current-1;
            while (!sieves[curLeft] && curLeft > left ) {
                curLeft--;
            }
            if (!sieves[curLeft]) {
                break;
            }

            if ((current-curLeft) <= minDif) {
                minDif = current - curLeft;
                result[0] = curLeft;
                result[1] = current;
            }

            current = curLeft;

        }

        return result;

    }


}
