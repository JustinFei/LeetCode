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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode nextMid = mid.next;
        mid.next = null;
        
        ListNode p1 = head;
        ListNode p2 = reverse(nextMid);
        ListNode next1 = null;
        ListNode next2 = null;
        ListNode pre = null;
        
        while (p1 != null && p2 != null) {
            next1 = p1.next;
            next2 = p2.next;
            
            p1.next = p2;
            p2.next = next1;
            
            pre = p2;
            
            p1 = next1;
            p2 = next2;
        }
        if (p1 != null) {
            pre.next = p1;
        }
    }
    
    private ListNode findMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}