public class _4_28 {

//    https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/comments/

    public int[] singleNumbers(int[] nums) {
        int sum=0;
        //得到异或结果，即为不相同两个数的异或结果sum
        for(int num:nums)
            sum^=num;
        //得到sum的二进制的1的最低位
        int flag=(-sum)&sum;
        int result[]=new int[2];
        //分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
        for(int num:nums){
            if((flag&num)==0)
                result[0]^=num;
            else{
                result[1]^=num;
            }
        }
        return result;
    }

}
