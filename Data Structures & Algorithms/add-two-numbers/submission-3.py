# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        carry = 0
        curr = dummy
        while l1 is not None or l2 is not None or carry!= 0:
            val_1 = l1.val if l1 else 0
            val_2 = l2.val if l2 else 0
            sum_val = val_1 + val_2 + carry
            carry = sum_val // 10
            curr.next = ListNode(sum_val%10)
            curr = curr.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        return dummy.next