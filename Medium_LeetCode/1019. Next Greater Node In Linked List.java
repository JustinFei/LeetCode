// O (n)
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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            list.add(node.val);
        }

        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}

// -------------------------------------------------------------------------------

// O(n2)
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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode dummy = new ListNode(0, head);
        ListNode next, cur = dummy;
        int nextGreaterVal;
        while (cur.next != null) {
            cur = cur.next;
            next = cur.next;
            nextGreaterVal = 0;
            while (next != null) {
                if (next.val > cur.val) {
                    nextGreaterVal = next.val;
                    break;
                }
                next = next.next;
            }
            list.add(nextGreaterVal);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}