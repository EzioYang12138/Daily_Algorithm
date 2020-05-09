public class _5_09 {

//    https://leetcode-cn.com/problems/sqrtx/

    public int mySqrt(int x) {

        if(x == 1) return 1;
        int min = 0;
        int max = x;

        while(max - min > 1) {
            int m = (max + min) / 2;
            if(x / m < m) {
                max = m;
            }else {
                min = m;
            }
        }

        return min;
    }
}
