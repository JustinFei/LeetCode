public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start=new ListNode(0),slow=start,fast=start;
    start.next=head;
    for(int i=0;i<n;i++) fast=fast.next;
    while(fast.next!=null) {fast=fast.next;slow=slow.next;}
    slow.next=slow.next.next;
    return start.next;
}