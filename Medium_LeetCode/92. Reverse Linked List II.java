/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        while (m > 1) {
            slow = slow.next;
            m--;
        }
        ListNode fast = dummy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode second = fast.next;
        fast.next = null;
        slow.next = reverse(slow.next);
        while (slow.next != null) {
            slow = slow.next;
        }
        slow.next = second;
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = head.next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}