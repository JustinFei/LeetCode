/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB: a.next;
            b = b == null ? headA : b. next;
        }
        return a;
    }
}

//----------------------------------------------

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headA : a.next;
            b = b == null ? headB : b.next;
        }
        return a;
    }
}

//------------------------------------

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int cnt1 = 0, cnt2 = 0;
        ListNode head = headA;

        while (head != null){
            cnt1++;
            head = head.next;
        }

        head = headB;

        while (head != null) {
            cnt2++;
            head = head.next;
        }

        while (cnt1 > cnt2) {
            headA = headA.next;
            cnt1--;
        }

        while (cnt1 < cnt2) {
            headB = headB.next;
            cnt2--;
        }

       //Here is the trick: using check condition to find the intersection
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}