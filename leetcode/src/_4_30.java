
//https://leetcode-cn.com/problems/happy-number/

public class _4_30 {

    //如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是
//两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = helper(slow);
            fast = helper(fast);
            fast = helper(fast);
        } while (slow != fast);

        if (fast == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int helper(int m) {
        int res = 0;
        while (m != 0) {
            res += (m % 10) * (m % 10);
            m /= 10;
        }

        return res;
    }
}
