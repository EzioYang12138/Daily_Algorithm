public class _03_06 {

    public int[] nextGreaterElements(int[] nums) {
        int[] newnum = new int[nums.length * 2];

        for(int i = 0 ; i< 2 * nums.length; i++) {
            newnum[i] = nums[i % nums.length];
        }

        int[] res = new int[nums.length];

        for(int i = 0 ;i < nums.length; i++)  {
            res[i] = -1;

            for(int j = i+1; j <= nums.length + i; j++) {
                if(newnum[j] > nums[i]) {
                    res[i] = newnum[j];
                    break;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {1,5,3,6,8};
        int[] res = new _03_06().nextGreaterElements(nums);

        for(int i : res) {
            System.out.println(i);
        }
    }
}
