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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    int count = 0;
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
        ListNode tem = head;
        while(tem != null) {
            count++;
            tem = tem.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode res = head;
        Random r = new Random();
        int random = r.nextInt(count);
        for (int i = 0; i < random; i++) {
            res = res.next;
        }
        return res.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//------------------------------
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
    ArrayList<Integer> nodes = new ArrayList<>();
    public Solution(ListNode head) {
        while (head != null) {
            this.nodes.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int i = (int)(Math.random() * this.nodes.size());
        return this.nodes.get(i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */