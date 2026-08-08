class Solution {
    private Queue<int[]> q = new LinkedList<>();
    int n,m,fresh;
  private  int[][] dir ={{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        fresh=0;
int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});

                }
                else if(grid[i][j]==1){
     fresh++;
                }
            }
        }
        return bfs(grid);
       
    }

    private int bfs(int grid[][]){
     
         int steps=0;
        while(!q.isEmpty()){
            int size =q.size();

            while(size-->0){
              int curr[] = q.poll();

              int r = curr[0],c = curr[1];

              for(int[] dir :dir){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nc>=0 && nr>=0 && nr<n && nc<m && grid[nr][nc]==1){
                    grid[nr][nc] = 2;
                     fresh--;
                    q.add(new int[]{nr,nc});
                }
              }
               
            }
          if(!q.isEmpty())steps++;
            
        }
      if(fresh>0) return -1;
      else return steps;
    }
}
