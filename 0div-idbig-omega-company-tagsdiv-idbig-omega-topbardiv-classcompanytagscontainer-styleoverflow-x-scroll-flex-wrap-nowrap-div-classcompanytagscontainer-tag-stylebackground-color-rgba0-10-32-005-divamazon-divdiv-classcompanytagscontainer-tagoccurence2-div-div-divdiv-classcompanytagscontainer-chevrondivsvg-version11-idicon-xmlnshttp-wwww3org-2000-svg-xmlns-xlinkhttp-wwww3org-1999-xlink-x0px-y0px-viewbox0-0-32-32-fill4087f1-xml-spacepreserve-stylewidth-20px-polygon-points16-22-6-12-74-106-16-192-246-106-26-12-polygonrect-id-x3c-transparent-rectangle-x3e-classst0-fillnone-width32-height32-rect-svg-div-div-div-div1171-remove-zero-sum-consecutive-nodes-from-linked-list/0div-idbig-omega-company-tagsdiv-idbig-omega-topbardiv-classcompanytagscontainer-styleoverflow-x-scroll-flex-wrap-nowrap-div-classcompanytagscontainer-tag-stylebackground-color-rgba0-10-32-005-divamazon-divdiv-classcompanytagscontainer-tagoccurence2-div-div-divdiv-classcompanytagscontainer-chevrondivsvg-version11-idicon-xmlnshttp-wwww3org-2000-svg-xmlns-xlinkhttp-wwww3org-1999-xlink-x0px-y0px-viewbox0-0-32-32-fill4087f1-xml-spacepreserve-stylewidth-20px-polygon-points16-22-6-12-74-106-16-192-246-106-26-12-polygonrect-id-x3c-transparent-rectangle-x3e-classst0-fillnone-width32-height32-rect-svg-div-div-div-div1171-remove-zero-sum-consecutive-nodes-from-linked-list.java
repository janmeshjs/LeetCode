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
    public ListNode removeZeroSumSublists(ListNode head) {
    ListNode temp = new ListNode(0, head);
    int prefix = 0;
    Map<Integer, ListNode> map = new HashMap<>();
    map.put(0, temp);

    for (; head != null; head = head.next) {
      prefix += head.val;
      map.put(prefix, head);
    }

    prefix = 0;

    for (head = temp; head != null; head = head.next) {
      prefix += head.val;
      head.next = map.get(prefix).next;
    }

    return temp.next;
    }
}