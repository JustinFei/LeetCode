/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * This type of question can split into 2 steps to solve ( like reverse in pair , reverse in 3 node ... )
 * Here is my solution follow this 2 steps and with little more clear naming conventions.
 */
 public ListNode reverseKGroup(ListNode head, int k) {
    //1. test weather we have more then k node left, if less then k node left we just return head 
    ListNode node = head;
    int count = 0;
    while (count < k) { 
        if(node == null)return head;
        node = node.next;
        count++;
    }
    // 2.reverse k node at current level 
       ListNode pre = reverseKGroup(node, k); //pre node point to the the answer of sub-problem 
        while (count > 0) {  
            ListNode next = head.next; 
            head.next = pre; 
            pre = head; 
            head = next;
            count--;
        }
        return pre;
}
//-----------------------------------------------------
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode start = head;
        ListNode end = null;
        ListNode nextStart = null;
        while (start != null) {
            end = getEnd(start, k);
            nextStart = end != null? end.next : null;
            cur.next = reverse(start, end);
            cur = start;
            start = nextStart;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, ListNode end) {
        if (end == null || head == null || head.next == null) {
            return head;
        }
        end.next = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    private ListNode getEnd(ListNode head, int k) {
        while (k > 1 && head != null) {
            head = head.next;
            k--;
        }
        return head != null ? head: null;
    }
}