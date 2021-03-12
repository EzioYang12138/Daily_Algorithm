import java.util.Stack;

public class _03_12 {

//    从序列起始处开始遍历,如果遇到数值就入栈，如果遇到"#"号,说明该位置已经到达了叶子节点,这时候需要查看栈顶是否也为"#",
//    如果是,说明栈顶的前一位置就是该叶子节点的父节点.因此我们将栈顶元素和栈顶的上一元素出栈,
//    然后用"#"替代(入栈,表示某一分支已经结束),这样操作后,最终根节点的左右孩子都会被替代为"#"，
//    合并后栈中只剩下一个"#"，表明所有节点都已经遍历完。如果最后栈中大小不为1，说明该序列是错误的

    public boolean isValidSerialization(String preorder) {

        Stack<Character> stack = new Stack<>();

        if (preorder.length() == 1) {
            return preorder.charAt(0) == '#';
        }

        for (int i = 0; i < preorder.length(); ) {
            if (preorder.charAt(i) == ',') {
                i++;
                continue;
            }

            StringBuilder temp = new StringBuilder();

            while (i < preorder.length() && preorder.charAt(i) != ',') {
                temp.append(preorder.charAt(i++));
            }

            if (stack.size() == 1 && stack.peek() == '#') {
                return false;
            }

            if (!temp.toString().equals("#")) {
                stack.push('a');
            } else {
                while (stack.size() >= 2 && stack.peek() == '#') {
                    stack.pop();
                    stack.pop();
                }

                stack.push('#');
            }
        }

        return stack.size() == 1;
    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean flag = new _03_12().isValidSerialization(s);
        System.out.println(flag);
    }
}
