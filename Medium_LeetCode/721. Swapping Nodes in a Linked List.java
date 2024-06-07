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
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
            
        ListNode cur = dummy;
        int l = 0;
        while (cur.next != null) {
            cur = cur.next;
            l++;
        }
        int fc = k - 1;
        ListNode fp = dummy;
        while (fc > 0) {
            fp = fp.next;
            fc--;
        }
        
        int sc = l - k;
        ListNode sp = dummy;
        while (sc > 0) {
            sp = sp.next;
            sc--;
        }
        
        ListNode f = fp.next;
        ListNode s = sp.next;
        
        ListNode fn = f.next;
        ListNode sn = s.next;
        
        if (f == s) {
            return head;
        } else if (fn == s) {
            fp.next = s;
            f.next = sn;
            s.next = f;
        } else if (sn == f) {
            sp.next = f;
            f.next = s;
            s.next = fn;
        } else {
            fp.next = s;
            sp.next = f;
            f.next = sn;
            s.next = fn;
        }
        return dummy.next;
    }
}