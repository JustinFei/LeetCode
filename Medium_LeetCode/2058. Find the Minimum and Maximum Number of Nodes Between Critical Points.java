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
	public int[] nodesBetweenCriticalPoints(ListNode head) {
		int[] res = new int[]{-1, -1};

		List<Integer> list = new ArrayList<>();
		int pre = head.val;
		head = head.next;
		int i = 1;
		while (head.next != null) {
		if ((head.val < pre && head.val < head.next.val) ||
			(head.val > pre && head.val > head.next.val))
			list.add(i);
			i++;
			pre = head.val;
			head = head.next;
		}

		int n = list.size();
		if (n <= 1) return res;
		res[0] = list.get(1) - list.get(0);
		res[1] = list.get(n - 1) - list.get(0);
		for (int j = 0; j < n - 1; j++)
		res[0] = Math.min(res[0], list.get(j + 1) - list.get(j));
		
		return res;
	}
}