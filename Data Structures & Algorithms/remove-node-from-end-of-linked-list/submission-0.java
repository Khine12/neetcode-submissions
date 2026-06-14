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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre_head = new ListNode(0);

        pre_head.next = head;

        ListNode fast = pre_head;

        ListNode slow = pre_head;

        for(int i = 0; i < n ; i++){

            fast = fast.next;
        }

        while(fast.next != null){

            fast = fast.next;

            slow = slow.next;
        }

        slow.next = slow.next.next;

        return pre_head.next;

    }
}
