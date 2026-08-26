class Solution {
    public int swimInWater(int[][] grid) {
        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b)->a.dist-b.dist); //min heap m asedning order with respect to dist 
        minHeap.add(new Node(grid[0][0],0,0));
        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            int dis = node.dist;
            int i = node.i;
            int j = node.j;
            if(vis[i][j]) continue;
            dist[i][j] = dis;
            vis[i][j]= true;
            for(int arr[]: dir){
                int nr = i+arr[0];
                int nc = j+arr[1];
                if(nr<0 || nc<0 || nr>=n|| nc>=m) continue;
               int max = Math.max(dis,grid[nr][nc]);
               if(max<dist[nr][nc]){
                dist[nr][nc] = max;
                minHeap.add(new Node(max,nr,nc));
               }
            }

        }
        return dist[n-1][m-1];
    }
}
class Node{
    int dist;
    int i;
    int j;
    Node(int dist,int i,int j){
        this.dist = dist;
        this.i = i;
        this.j = j;
    }

}
