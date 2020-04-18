//11. 盛最多水的容器

//https://leetcode-cn.com/problems/container-with-most-water/

public class _4_18 {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int res = 0;

        while(left < right) {
            res = Math.max(res , (right - left) * Math.min(height[left] , height[right]));

            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }

        }

        return res;
    }

    public static void main(String[] args) {

        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new _4_18().maxArea(height));
    }

}
