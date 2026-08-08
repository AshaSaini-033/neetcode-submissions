class Solution {

    private int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    private int INF =  2147483647;
     Queue<int[]> q = new LinkedList<>();
   
    private int n, m;
    public void islandsAndTreasure(int[][] grid) {
         n = grid.length;
         m = grid[0].length;
   
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
    
       int steps = 0;
       while(!q.isEmpty()){
        int size = q.size();
       
        for(int k=0;k<size;k++){
            int[] curr = q.poll();
            int r = curr[0],c = curr[1];

        
            for(int[] dir: dir){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr>=0 && nr<n && nc>=0 && nc<m &&  grid[nr][nc]==INF){
                 grid[nr][nc] = steps+1;
                    q.add(new int[]{nr,nc});
                }
            }

        }
        steps++;
       }


    }
   
}
