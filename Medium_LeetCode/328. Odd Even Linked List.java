
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode cur = head.next.next;
        int i = 1;
        ListNode curOdd = odd;
        ListNode curEven = even;
        while (cur != null) {
            if (i % 2 == 1) {
                curOdd.next = cur;
                curOdd = curOdd.next;
            } else {
                curEven.next = cur;
                curEven = curEven.next;
            }
            cur = cur.next;
            i++;
        }
        curOdd.next = null;
        curEven.next = null;
        curOdd.next = even;
        return odd;
    }
}


//-----------------
public class Solution {
	public ListNode oddEvenList(ListNode head) {
	    if (head != null) {
	    
	        ListNode odd = head, even = head.next, evenHead = even; 
	    
	        while (even != null && even.next != null) {
	            odd.next = odd.next.next; 
	            even.next = even.next.next; 
	            odd = odd.next;
	            even = even.next;
	        }
	        odd.next = evenHead; 
	    }
	    return head;
	}
}