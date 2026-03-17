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
    public ListNode rotateRight(ListNode head, int k) {
         if (head == null || head.next == null) return head;
         k = k % getLength(head);
        for(int i=1;i<=k;i++){
            ListNode temp=head;  
            while(temp.next.next!=null){
                temp=temp.next;
            }
            ListNode last = temp.next; 
            temp.next = null;
            last.next = head;
            head = last;
        }
        return head;
    }
     private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}