public class _01_24 {

    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int temp = nums[0];
        int res = 1;
        int tempres = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp) {
                tempres += 1;

            } else {

                tempres = 1;

            }
            res = Math.max(res, tempres);
            temp = nums[i];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 5, 7};
        int res = new _01_24().findLengthOfLCIS(nums);

        System.out.println(res);
    }
}
