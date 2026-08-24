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

        int len = findLen(head);
        ListNode temp = head;
        ListNode head1=head;
        int half = len/2;
        
        while(half!=0){
          
            half--;
              temp= temp.next;
        }
        ListNode h2 = temp.next;
        temp.next = null;
        ListNode head2 = reverse(h2);
       ListNode nxt1 = null;
       ListNode nxt2 = null;
       ListNode temp1 = head1;
       ListNode temp2 = head2;

       while(temp1!=null && temp2!=null){
        nxt1 = temp1.next;
        nxt2 = temp2.next;
        temp1.next = temp2;
        temp2.next = nxt1;
        temp1=nxt1;
        temp2=nxt2;
       }
     
        
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode nxt = null;
        ListNode temp = head;
        while(temp!=null){
            nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        
        }
        return prev;
    }
    public int findLen(ListNode head){
 ListNode temp = head;
 int cnt=0;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }
        return cnt;

    }
}
