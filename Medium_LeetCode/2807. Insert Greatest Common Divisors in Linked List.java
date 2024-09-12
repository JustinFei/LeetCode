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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head, next = head.next;
        while (next != null) {
            int gcd = gcd(cur.val, next.val);
            cur.next = new ListNode(gcd, next);
            cur = next;
            next = next.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, Math.abs(a - b));
    }
}