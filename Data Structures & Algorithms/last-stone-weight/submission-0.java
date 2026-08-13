class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            maxheap.add(stones[i]);
        }
        while(maxheap.size()>1){
            int x = maxheap.poll();
            int y = maxheap.poll();

           int diff = Math.abs(x-y);
            if(diff!=0){
                maxheap.add(diff);
            }
        }
        if(maxheap.size()!=0) return maxheap.poll();
        else return 0;
    }
}
