public class swapAndReverse {
    public static ListNode swapAndReverse(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        // Step 1: find length
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int startPos = k;
        int endPos = length - k + 1;

        if (startPos >= endPos)
            return head; // nothing to reverse

        // Step 2: locate nodes
        ListNode nodeStart = head, nodeEnd = head;
        ListNode beforeStart = null, beforeEnd = null;

        for (int i = 1; i < startPos; i++) {
            beforeStart = nodeStart;
            nodeStart = nodeStart.next;
        }

        for (int i = 1; i < endPos; i++) {
            beforeEnd = nodeEnd;
            nodeEnd = nodeEnd.next;
        }

        // Step 3: swap values
        int t = nodeStart.val;
        nodeStart.val = nodeEnd.val;
        nodeEnd.val = t;

        // Step 4: reverse between nodeStart.next and nodeEnd (exclusive)
        ListNode prev = nodeEnd;
        ListNode curr = nodeStart.next;

        while (curr != nodeEnd) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        nodeStart.next = prev;

        return head;
    }

}
