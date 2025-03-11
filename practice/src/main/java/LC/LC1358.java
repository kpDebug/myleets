package LC;

import interfaces.LeetCodeQuestion;

public class LC1358 implements LeetCodeQuestion {
    @Override
    public void solution() {

        String s = "abc";
        int res = numberOfSubstrings(s);
        System.out.println(res);
    }

    public int numberOfSubstrings(String s) {

        int start = 0,end = 0;
        int n = s.length();
        int[] curCounts=new int[3];
        int res = 0;

        while (end < n) {
            char curChar = s.charAt(end);
            curCounts[curChar-97]++;

            if (isValidSubString(curCounts)) {
                while (isValidSubString(curCounts)) {
                    res += (n-end);
                    curCounts[s.charAt(start)-97]--;
                    start++;
                }
            }
            end++;
        }

        return res;
    }

    private static boolean isValidSubString(int[] curCounts) {
        return curCounts[0] != 0 && curCounts[1] != 0 && curCounts[2] != 0;
    }
}
