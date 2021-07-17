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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode t1 = l1, t2 = l2;
    ListNode dummy = new ListNode(-1);
    ListNode temp = dummy;
    int carry = 0, newVal = 0;
    while (t1 != null || t2 != null || carry > 0) {
      newVal = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val) + carry;
      carry = newVal / 10;
      newVal %= 10;
      temp.next = new ListNode(newVal);
      t1 = t1 == null ? null : t1.next;
      t2 = t2 == null ? null : t2.next;
      temp = temp.next;
    }
    return dummy.next;
  }
}
