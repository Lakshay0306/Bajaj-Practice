class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prevGroupTail = sentinel;

        while (true) {
            ListNode kthNode = findKthNode(prevGroupTail, k);
            if (kthNode == null) break;

            ListNode nextGroupHead = kthNode.next;

            ListNode prev = nextGroupHead;
            ListNode curr = prevGroupTail.next;
            while (curr != nextGroupHead) {
                ListNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }

            ListNode groupStart = prevGroupTail.next;
            prevGroupTail.next = kthNode;
            prevGroupTail = groupStart;
        }

        return sentinel.next;
    }

    private ListNode findKthNode(ListNode start, int k) {
        ListNode ptr = start;
        for (int i = 0; i < k && ptr != null; i++) {
            ptr = ptr.next;
        }
        return ptr;
    }
}
