import java.util.ArrayList;
import java.util.List;

public class _03_07 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s , 0 , new ArrayList<>());
        return res;
    }

    private void dfs(String s , int start, ArrayList<String> path ) {
        if(start == s.length()) {
            res.add(new ArrayList<>(path));
        }

        for(int i = start; i < s.length(); i++) {
            String s1 = s.substring(start , i + 1);
            if(!isPalindrome(s1)) {
                continue;
            }
            path.add(s1);
            dfs(s , i + 1 , path);
            path.remove(path.size() - 1);
        }

    }

    private boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = new _03_07().partition(s);

        System.out.println(res);
    }
}
