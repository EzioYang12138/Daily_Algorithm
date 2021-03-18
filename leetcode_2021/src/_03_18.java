import java.util.Stack;

public class _03_18 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int len = 0;

        ListNode temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        ListNode cur1 = new ListNode();
        ListNode temp1 = cur1;
        ListNode cur2 = new ListNode();
        ListNode temp2 = cur2;

        for (int i = 1; i < left; i++) {
            temp1.next = head;
            head = head.next;
            temp1 = temp1.next;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = left; i <= right; i++) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode reverse = new ListNode();
        ListNode reverseTemp = reverse;
        while (!stack.isEmpty()) {
            reverseTemp.next = new ListNode(stack.pop());
            reverseTemp = reverseTemp.next;
        }

        for (int i = right + 1; i <= len; i++) {
            temp2.next = head;
            head = head.next;
            temp2 = temp2.next;
        }

        temp1.next = reverse.next;
        reverseTemp.next = cur2.next;

        return cur1.next;
    }


}
