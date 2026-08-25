class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean vis[] = new boolean[n];
        dist[0] = 0;

        int ans=0;
        for(int i=0;i<n;i++){
            //find min disttance
            int min = Integer.MAX_VALUE;
            int curr =-1;
            for(int j=0;j<n;j++){
               if(!vis[j] && dist[j]<min){
                min = dist[j];
                curr=j;
               }
            }  
            //add this to mst
            vis[curr] = true;
            ans +=dist[curr];

            for(int j=0;j<n;j++){
                if(!vis[j]){
                    int newDist = Math.abs(points[curr][0]-points[j][0])+Math.abs(points[curr][1]-points[j][1]);

                    dist[j] = Math.min(dist[j],newDist);
                }

            }
        }
        return ans;

    }
}
