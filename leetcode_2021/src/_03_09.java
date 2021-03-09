import java.util.Stack;

public class _03_09 {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArrays = s.toCharArray();

        for(char c : charArrays) {
            if(!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        StringBuilder temp = new StringBuilder();

        while(!stack.isEmpty()) {

            temp.append(stack.pop());
        }

        return temp.reverse().toString();


    }

//    public static void main(String[] args) {
//        new _03_09().removeDuplicates(s);
//    }
}
