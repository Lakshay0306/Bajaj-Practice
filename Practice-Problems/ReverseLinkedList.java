class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode upcoming = current.next;
            current.next = previous;
            previous = current;
            current = upcoming;
        }

        return previous;
    }
}
