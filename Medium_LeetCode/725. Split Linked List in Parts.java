/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        if (head == null) return res;
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) len++;

        int s = len / k, r = len % k;
        ListNode node = head, prev = null;
        for (int i = 0; node != null && i < k; i++, r--) {
            res[i] = node;
            for (int j = 0; j < s + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }

        return res;
    }
}