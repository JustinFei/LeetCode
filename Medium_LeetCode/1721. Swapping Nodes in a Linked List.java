class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int count = 0;

        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        int b = count - k;

        ListNode x = head, y = head;

        while (k > 1) {
            x = x.next;
            k--;
        }

        while (b > 0) {
            y = y.next;
            b--;
        }

        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
        
        return head;
    }
}
//-----------------------------------
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode first = head, second = head;
        
        // Put fast (k-1) nodes after slow
        for(int i = 0; i < k - 1; ++i)
            fast = fast.next;
            
        // Save the node for swapping
        first = fast;

        // Move until the end of the list
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Save the second node for swapping
        // Note that the pointer second isn't necessary: we could use slow for swapping as well
        // However, having second improves readability
        second = slow;
        
        // Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
        
    }
}