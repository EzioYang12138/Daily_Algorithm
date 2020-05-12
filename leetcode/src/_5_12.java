import java.util.Stack;

//https://leetcode-cn.com/problems/min-stack/

public class _5_12 {
    /**
     * initialize your data structure here.
     */

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public _5_12() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {

//        一定要用equals !!!! 老是习惯性的用 ==
        if(stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
