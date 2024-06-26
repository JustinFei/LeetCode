/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        
        ListNode faster = head, slower = head;
        
        while(faster.next != null && faster.next.next != null){
            
            slower = slower.next;
            faster = faster.next.next;
            
            if(faster == slower) {
                return true;
            }
        }
        return false;
    }
}