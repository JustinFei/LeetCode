/**
* Definition for singly-linked list.
* public class ListNode {
* int val;
* ListNode next;
* ListNode() {}
* ListNode(int val) { this.val = val; }
* ListNode(int val, ListNode next) { this.val = val; this.next = next; }
* }
*/
class Solution {
	public ListNode mergeNodes(ListNode head) {
		int sum = 0;
		ListNode newHead = new ListNode(0), cur = newHead;
		head = head.next; // Skip the head 0;
		while (head != null) {
			if (head.val == 0) {
				cur.val = sum;
				if (head.next != null) cur.next = new ListNode(0);
				cur = cur.next;
				sum = 0;
			} else {
				sum += head.val;
			}

			head = head.next;
		}

		return newHead;
	}
}