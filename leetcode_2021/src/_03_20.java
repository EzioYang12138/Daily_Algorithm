import java.util.Stack;

public class _03_20 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int res = 0;

                int n2 = stack.pop();

                int n1 = stack.pop();

                switch (token) {
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "/":
                        res = n1 / n2;
                        break;
                    default:
                        res = n1 * n2;
                        break;
                }

                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.peek();
    }


}
