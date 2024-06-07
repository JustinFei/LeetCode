/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
     if(head == null) return null;
     if(head.next == null) return head;
     ListNode node = reverseList(head.next);
     head.next.next = head;
     head.next=null;
     return node;  
    }
}