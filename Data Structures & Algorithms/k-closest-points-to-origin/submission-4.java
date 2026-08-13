class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //comparing on basis of distanace kyuki sqrt to incresing function hai 
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        int n  = points.length;
        
        int ans[][] = new int[k][2];

        for(int i=0;i<n;i++){
          
            maxheap.add(points[i]);
            if(maxheap.size()>k)maxheap.poll();
        }
        int i=0;
        while(maxheap.size()>0){
           ans[i] = maxheap.poll();
            i++;
        }
        return ans;

    }
}
