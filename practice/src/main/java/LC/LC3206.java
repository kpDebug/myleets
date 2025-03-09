package LC;

import interfaces.LeetCodeQuestion;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

/**
 * 3206. Alternating Groups I
 * Easy
 * Topics
 * Companies
 * Hint
 * There is a circle of red and blue tiles. You are given an array of integers colors. The color of tile i is represented by colors[i]:
 *
 * colors[i] == 0 means that tile i is red.
 * colors[i] == 1 means that tile i is blue.
 * Every 3 contiguous tiles in the circle with alternating colors (the middle tile has a different color from its left and right tiles) is called an alternating group.
 *
 * Return the number of alternating groups.
 *
 * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
 *
 *
 *
 * Example 1:
 *
 * Input: colors = [1,1,1]
 *
 * Output: 0
 *
 * Explanation:
 *
 *
 *
 * Example 2:
 *
 * Input: colors = [0,1,0,0,1]
 *
 * Output: 3
 *
 * Explanation:
 *
 *
 *
 * Alternating groups:
 *
 *
 *
 *
 *
 * Constraints:
 *
 * 3 <= colors.length <= 100
 * 0 <= colors[i] <= 1
 */
public class LC3206 implements LeetCodeQuestion {


    @Override
    public void solution() {
        int[] colors = new int[]{1,1,0,1};
        int res = numberOfAlternatingGroups(colors);
        System.out.println(res);
    }

    public int numberOfAlternatingGroups(int[] colors) {
        int res=0;
        int k=4;
        int n=colors.length;
        boolean isAlternateColors = true;
        int[] newColors = new int[n+k-1];

        for (int i=0;i<n;i++) {
            newColors[i] = colors[i];
            if (i < k-1) {
                newColors[i+n] = colors[i];
            }
        }
        int curIntervalSize = 1;
        for (int i=1;i<(k+n-1);i++) {
            if (newColors[i] == newColors[i-1]) {
                curIntervalSize = 1;
            } else {
                curIntervalSize++;
                if (curIntervalSize >= k) {
                    res++;
                }
            }
        }

        return res;

    }
}
