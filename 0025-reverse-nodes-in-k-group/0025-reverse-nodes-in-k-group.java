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
        ListNode dummy = new ListNode(0);
          dummy.next=head;
          ListNode prev=dummy;
          while(true){
            ListNode kth=prev;
            for(int i=0;i<k;i++){
                kth=kth.next;
                if(kth == null) return dummy.next;
            }
           ListNode groupstart= prev.next;
           ListNode nextgroup=kth.next;

           ListNode curr=groupstart;
           ListNode p=nextgroup;
           while(curr!=nextgroup){
           ListNode temp=curr.next;
            curr.next=p;
            p=curr;
            curr=temp;
           }
           prev.next=kth;
            prev = groupstart;
          }
    }
}