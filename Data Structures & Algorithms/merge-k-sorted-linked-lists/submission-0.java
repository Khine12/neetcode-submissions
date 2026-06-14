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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;

        int interval = 1;

        while(interval < lists.length){

            for(int i=0; i+interval<lists.length; i += interval*2){

                lists[i] = mergeTwoLists(lists[i],lists[i+interval]);
            }

            interval*=2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b){

        ListNode pre_head = new ListNode(-1);

        ListNode dummy = pre_head;

        while(a!=null && b!=null){

            if(a.val <= b.val){

                dummy.next = a;

                a = a.next;
            }
            else{

                dummy.next = b;

                b = b.next;
            }

            dummy = dummy.next;
        }

        dummy.next = (a!=null) ? a : b;

        return pre_head.next;
    }
}
