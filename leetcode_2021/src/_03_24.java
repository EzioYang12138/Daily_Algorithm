import java.util.Stack;

public class _03_24 {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int last = Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack<>();

        if (nums.length < 3) {
            return false;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < last) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                last = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}
