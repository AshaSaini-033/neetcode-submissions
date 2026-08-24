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
 class obj{
    int idx;
    ListNode node;
    obj(int idx,ListNode node){
        this.idx = idx;
        this.node = node;
    }
 }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<obj> pq = new PriorityQueue<>((a,b)->Integer.compare(a.node.val,b.node.val));
      ListNode dummy= new ListNode(0);
      ListNode temp = dummy;
      for(int i=0;i<lists.length;i++){
       if(lists[i]!=null) pq.add(new obj(i,lists[i]));
      }
      while(!pq.isEmpty()){
    obj o = pq.poll();
    int i= o.idx;
  
    temp.next =o.node;
    temp = temp.next;

   if(o.node.next!=null){
    pq.add(new obj(i,o.node.next));
   }
      }
      return dummy.next;

    }
}
