package LC;

import interfaces.LeetCodeQuestion;

/**
 * There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:
 *
 * colors[i] == 0 means that tile i is red.
 * colors[i] == 1 means that tile i is blue.
 * An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
 *
 * Return the number of alternating groups.
 *
 * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
 *
 *
 *
 * Example 1:
 *
 * Input: colors = [0,1,0,1,0], k = 3
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
 * Example 2:
 *
 * Input: colors = [0,1,0,0,1,0,1], k = 6
 *
 * Output: 2
 *
 * Explanation:
 *
 *
 *
 * Alternating groups:
 *
 *
 *
 * Example 3:
 *
 * Input: colors = [1,1,0,1], k = 4
 *
 * Output: 0
 */

public class LC3208 implements LeetCodeQuestion {


    @Override
    public void solution() {
        int[] colors = new int[]{1,1,0,1};
        int k=4;
        int res = numberOfAlternatingGroups(colors, k);
        System.out.println(res);
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res=0;
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
