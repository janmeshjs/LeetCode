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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;

        //to find middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }

        //to reverse after middle
        ListNode prev = slow;
        ListNode curr = slow.next;
        while(curr.next!=null){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
//joining list
    slow = head;
    fast = prev.next;
        while(slow!=prev){
            prev.next = fast.next;
            fast.next = slow.next;
           slow.next = fast;
            slow = fast.next;
            fast = prev.next;
        }

    }
}