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
    public int[] nextLargerNodes(ListNode head) {
        List <Integer> vals=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
        vals.add(temp.val);
        temp=temp.next;
        }
        int n=vals.size();
        int res[] =new int[n];
        Deque <Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
             int curval=vals.get(i);
             while(!stack.isEmpty() && vals.get(stack.peek())<curval){
                int idx=stack.pop();
                res[idx]=curval;
             }
             stack.push(i);
        }
        return res;
    }
}