public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int k) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // normal addition step
            int digit = sum % 10;
            carry = sum / 10;

            // apply calibration factor
            digit = (digit * k) % 10;

            current.next = new ListNode(digit);
            current = current.next;
        }

        return dummy.next;
    }

}
