public class _6_10 {

//    https://leetcode-cn.com/problems/palindrome-number/submissions/

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int temp = x;
        int a = 0;

        while(x != 0) {
            a = a* 10 + x % 10;
            x /= 10;
        }

        return a == temp;
    }
}
