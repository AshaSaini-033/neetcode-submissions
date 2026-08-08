class Solution {
    boolean vis[][];
    int max = 0;
    int area=0;
    public int maxAreaOfIsland(int[][] grid) {
        
int n = grid.length;
int m =grid[0].length;
vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(!vis[i][j] && grid[i][j]==1){
                area = dfs(grid, vis, i, j);
    max = Math.max(max, area);
               }
         
            }
        }
        return max;
        
    }
    public int dfs(int grid[][],boolean vis[][],int i,int j){
         if(i<0 || j<0 || i>=grid.length|| j>= grid[0].length || grid[i][j] == 0 ||vis[i][j]){
            return 0;   
        }
         area++;
        
         vis[i][j] = true;

       return 1+ dfs(grid,vis,i+1,j)+dfs(grid,vis,i,j+1)+dfs(grid,vis,i-1,j)+dfs(grid,vis,i,j-1);


    }
}
