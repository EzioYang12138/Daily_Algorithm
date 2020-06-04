public class _6_04 {


//    除自己以外连乘左边跟右边
//    https://leetcode-cn.com/problems/product-of-array-except-self/

    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;

        int[] res = new int[nums.length];


        for (int i = 1; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];
        }


        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= right;
            right *= nums[j];
        }

        return res;
    }
}
