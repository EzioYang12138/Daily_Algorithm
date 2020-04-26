import java.util.PriorityQueue;

//https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/

public class _4_26 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int low = 0;
        int high = lists.length - 1;

        return merge(lists, low, high);
    }

    public ListNode merge(ListNode[] lists, int low, int high) {
        if (low >= high) return lists[low];

        int mid = low + (high - low) / 2;
        ListNode l1 = merge(lists, low, mid);
        ListNode l2 = merge(lists, mid + 1, high);
        return sort(l1, l2);
    }

    public ListNode sort(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = sort(l1.next, l2);
            return l1;
        } else {
            l2.next = sort(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        for (int i = 0; i < lists.length; i++) {
            queue.offer(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if(cur.next != null) {
                queue.offer(cur.next);
            }
        }

        return dummy.next;
    }
}
