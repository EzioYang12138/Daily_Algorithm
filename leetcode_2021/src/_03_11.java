import java.util.Stack;

public class _03_11 {

    public int calculate(String s) {
        int res = 0 , d = 0;

        char sign = '+';

        Stack<Integer> nums = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0') {
                d = d * 10 - '0' + s.charAt(i);
            }

            if(s.charAt(i) < '0' && s.charAt(i) != ' ' || i == s.length() - 1) {
                if(sign == '+') {
                    nums.push(d);
                }else if (sign == '-') {
                    nums.push(-d);
                }else if (sign == '*' || sign == '/') {
                    int temp = sign == '*' ? nums.peek() * d : nums.peek() / d;
                    nums.pop();
                    nums.push(temp);
                }

                sign = s.charAt(i);
                d = 0;
            }
        }

        for(; !nums.empty(); nums.pop()) {
            res += nums.peek();
        }

        return res;
    }
}
