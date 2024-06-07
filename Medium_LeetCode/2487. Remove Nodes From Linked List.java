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
    public ListNode removeNodes(ListNode head) {
        if (head == null) return head;
        head = reverse(head);
        ListNode cur = head;

        while (cur.next != null) {
            if (cur.val > cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, next;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next; 
        }

        return pre;
    }
}

// --------------------------------------------------------------------------

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
    public ListNode removeNodes(ListNode head) {
        if (head != null) {
            head.next = removeNodes(head.next);
            if (head.next != null && head.val < head.next.val) {
                return head.next;
            }
        }
        return head;
    }
}

// ----------------------------------------------------------------

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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stk = new ArrayDeque<>();
        while (head != null) {
            while (!stk.isEmpty() && stk.peek().val < head.val) {
                stk.pop();
            }
            stk.push(head);
            head = head.next;
        }
        while (stk.size() > 1) {
            ListNode n = stk.pop();
            stk.peek().next = n;
        }
        return stk.peek();
    }
}

// -------------------------------------------------------------
 
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

 // Time Limit Exceeded!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

class Solution {
    public ListNode removeNodes(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());

        ListNode cur = head;
        while (cur != null) {
            pq.offer(cur.val);
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0, head);
        cur = dummy;

        while (cur.next != null) {
            if (cur.next.val < pq.peek()) {
                pq.remove(cur.next.val);
                cur.next = cur.next.next;
            } else {
                pq.poll();
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}