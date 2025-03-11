package LC;

import interfaces.LeetCodeQuestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3306. Count of Substrings Containing Every Vowel and K Consonants II
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a string word and a non-negative integer k.
 *
 * Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "aeioqq", k = 1
 *
 * Output: 0
 *
 * Explanation:
 *
 * There is no substring with every vowel.
 *
 * Example 2:
 *
 * Input: word = "aeiou", k = 0
 *
 * Output: 1
 *
 * Explanation:
 *
 * The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".
 *
 * Example 3:
 *
 * Input: word = "ieaouqqieaouqq", k = 1
 *
 * Output: 3
 *
 * Explanation:
 *
 * The substrings with every vowel and one consonant are:
 *
 * word[0..5], which is "ieaouq".
 * word[6..11], which is "qieaou".
 * word[7..12], which is "ieaouq".
 *
 *
 * Constraints:
 *
 * 5 <= word.length <= 2 * 105
 * word consists only of lowercase English letters.
 * 0 <= k <= word.length - 5
 */

public class LC3306 implements LeetCodeQuestion {

    Set<Character> vowels;

    public LC3306() {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    @Override
    public void solution() {
        String word = "ieaouqqieaouqq";
        int k=1;
        long res = countOfSubstrings(word, k);
        System.out.println(res);
    }



    public long countOfSubstrings(String word, int k) {
        return minKCon(word, k) - minKCon(word, k+1);
    }

    private long minKCon(String word, int k) {
        int n = word.length();
        int start = 0, end =0;
        long res = 0;
        Map<Character, Integer> curSet = new HashMap<>();
        int curK=0;

        while (end < n) {

            char ch = word.charAt(end);
            if (vowels.contains(ch)) {
                int chCount = curSet.getOrDefault(ch, 0);
                curSet.put(ch, ++chCount);
            } else {
                curK++;
            }

            while (curSet.size() == vowels.size() &&  curK >= k) {
                res += word.length()  - end;

                char chStart = word.charAt(start);
                if (vowels.contains(chStart)) {
                    int chCount = curSet.get(chStart);
                    chCount--;
                    if (chCount > 0) {
                        curSet.put(chStart, --chCount);
                    } else {
                        curSet.remove(chStart);
                    }

                } else {
                    curK--;
                }
                start++;
            }

            end++;

        }

        return res;
    }
}
