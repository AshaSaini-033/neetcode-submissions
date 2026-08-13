class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
        minheap.add(nums[i]);
        if(minheap.size()>k){
            minheap.poll();
        }
        }
        return minheap.poll();
    }
}
