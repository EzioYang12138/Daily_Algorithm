public class _5_04 {


//    https://leetcode-cn.com/problems/jump-game-ii/

//    今天是五四青年节，翻滚吧！后浪！

    public int jump(int[] nums) {
        if(nums.length < 2) return 0;

        int res = 0;
        int curMaxArea = 0;
        int maxNext = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(maxNext , i + nums[i]);
            if(curMaxArea == i) {
                res++;
                curMaxArea = maxNext;
            }
        }

        return res;
    }
}
