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
    private ListNode reverse(ListNode node) {
        ListNode pre = null, next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);

        int tmp = 0, carry = 0;
        ListNode res = new ListNode();

        while (r1 != null || r2 != null) {
            if (r1 != null) {
                tmp += r1.val;
                r1 = r1.next;
            }
            if (r2 != null) {
                tmp += r2.val;
                r2 = r2.next;
            }

            res.val = tmp % 10;
            carry = tmp / 10;
            ListNode head = new ListNode(carry, res);
            res = head;
            tmp = carry;
        }

        return carry == 0 ? res.next : res;
    }
}

//----------------------------

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
    private Deque<Integer> toDeque(ListNode node) {
        Deque<Integer> deque = new LinkedList<>();
        while (node != null) {
            deque.offerLast(node.val);
            node = node.next;
        }
        return deque;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> d1 = toDeque(l1);
        Deque<Integer> d2 = toDeque(l2);
        boolean one = false;
        int tmp = 0, carry = 0;
        ListNode node = new ListNode();
        while (!d1.isEmpty() || !d2.isEmpty()) {
            if (!d1.isEmpty()) {
                tmp += d1.pollLast();
            }

            if (!d2.isEmpty()) {
                tmp += d2.pollLast();
            }

            node.val = tmp % 10;
            carry = tmp / 10;
            ListNode head = new ListNode(carry, node);
            node = head;
            tmp = carry;
        }

        return carry == 0 ? node.next : node;
    }
}