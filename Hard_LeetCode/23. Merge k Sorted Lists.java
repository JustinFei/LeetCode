/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new Comparator<ListNode>() {
           @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val == n2.val) return 0;
                return n1.val < n2.val ? -1 : 1;
            }
        });
        int k = lists.length;
        ListNode cur = null;
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);   
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (minHeap.size() != 0) {
            cur = minHeap.poll();
            if (cur.next != null) {
                minHeap.offer(cur.next);
            }
            head.next = cur;
            head = head.next;
        }
        return dummy.next;
    }
}