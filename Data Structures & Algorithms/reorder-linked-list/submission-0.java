/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;

            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;

        slow.next = null;

        ListNode prev = null;

        while (secondHead != null) {

            ListNode next = secondHead.next;

            secondHead.next = prev;

            prev = secondHead;

            secondHead = next;
        }

        secondHead = prev;

        ListNode first = head;

        while (secondHead != null) {

            ListNode firstHalf = first.next;

            ListNode secondHalf = secondHead.next;

            first.next = secondHead;

            secondHead.next = firstHalf;

            first = firstHalf;

            secondHead = secondHalf;
        }

    }
}