
/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public int sizeOfList(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = sizeOfList(head);
        int nthPosFromStart = size - n + 1;
        if (nthPosFromStart == 1) {
            return head.next;
        }
        ListNode curr = head;

        for (int i = 1; i < nthPosFromStart - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
// @lc code=end
