import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

public class _5_02 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;

        int res = 0;

        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i++));
            }

            res = Math.max(res, i - j);
        }

        return res;
    }

}
