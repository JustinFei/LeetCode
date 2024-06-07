/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        ListNode node = head;
        int length = 1;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        node.next = head;
        for (int i = 0; i < length - k % length; i++) {
            node = node.next;
        }
        
        head = node.next;
        node.next = null;
        return head;
    }
}

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = 1;
        ListNode fast = head;
        while(fast.next != null) {
            fast = fast.next;
            length++;
        }

        k %= length;
        if (k == 0) {
            return head;
        }
        
        fast = head;
        ListNode slow = head;
        while (k != 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}