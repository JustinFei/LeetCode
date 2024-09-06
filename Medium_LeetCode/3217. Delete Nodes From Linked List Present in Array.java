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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (nums == null || nums.length == 0 || head == null) return head;

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (head != null) {
            if (set.contains(head.val)) {
                cur.next = head.next;
            } else {
                cur = cur.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}