class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
         //number->freq
        for(int num :nums){
            if(map.containsKey(num)){
                map.put(num,map.getOrDefault(num,0)+1);
            }else{
                map.put(num,1);
            }
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]); //min heap
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getValue(),entry.getKey()});
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int i=0;i<k;i++){
            ans[i] = pq.poll()[1];

        }
        return ans;
    }
}
