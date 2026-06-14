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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode group_prev = dummy;

        while(true) {

            ListNode kth = get_kth(group_prev,k);

            if(kth == null) break;

            ListNode group_next = kth.next;

            ListNode curr = group_prev.next;

            ListNode prev = group_next;

            while(curr!=group_next){

                ListNode next = curr.next;

                curr.next = prev;

                prev = curr;

                curr = next;
            }

            ListNode old_head = group_prev.next;

            group_prev.next = kth;

            group_prev = old_head;

        }
        return dummy.next;
    }

    private ListNode get_kth(ListNode start,int k){

        ListNode curr = start;

        while(curr != null && k > 0){

            curr = curr.next;

            k--;
        }

        return curr;
    }
}
