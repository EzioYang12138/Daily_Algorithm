public class _5_16 {

//    https://leetcode-cn.com/problems/reverse-nodes-in-k-group/submissions/

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head , int k) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = null;

        dummy.next = head;
        int length = 0;

        while(head != null) {
            length++;
            head = head.next;
        }

        head = dummy.next;

        for(int i = 0; i < length / k ;i++) {
            for(int j = 0; j < k - 1; j++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }

            pre = cur;
            cur = pre.next;
        }

        return dummy.next;
    }
}
