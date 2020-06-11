import java.util.Stack;


//https://leetcode-cn.com/problems/daily-temperatures/submissions/

public class _6_11 {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[T.length];

        for(int i = 0; i < T.length; i++) {
            while(stack.isEmpty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop();


                res[temp] = i - temp;
            }

            stack.push(i);
        }

        return res;
    }
}
