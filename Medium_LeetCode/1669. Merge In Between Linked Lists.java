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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int p = 0;
        ListNode cur = list1;
        while (p != a - 1) {
            cur = cur.next;
            p++;
        }
        ListNode next = cur;
        while (p != b + 1) {
            next = next.next;
            p++;
        }
        cur.next = list2;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = next;
        return list1;
    }
}