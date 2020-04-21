import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/count-number-of-nice-subarrays/comments/

//    转换成    奇数为1, 偶数为0, 子区间和为k的种类数

public class _4_21 {

    public int numberOfSubarrays(int[] nums, int k) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }

        Map<Long, Integer> map = new HashMap<>();

        long sum = 0;

        map.put(0L, 1);

        int res = 0;

        for (int i = 1; i <= len; i++) {
            sum += nums[i - 1];
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return res;

    }

    public static void main(String[] args) {

        int[] nums = new int[] {1,1,2,1,1};
        int k = 3;
        int res = new _4_21().numberOfSubarrays(nums , k);

        System.out.println(res);
    }


}
