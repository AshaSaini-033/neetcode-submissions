class Solution {
     int n ;
      int m;

      int dir[][] = {{1,0},{0,1},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
             Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
           int cnt=  func(i,j,matrix,dp);
            max = Math.max(cnt,max);
              
           }
        }
        return max;
    }
    public int func(int i,int j,int matrix[][],int dp[][]){
        if(i>=n || j>=m ||i<0 || j<0) return 0 ;
if(dp[i][j]!=-1) return dp[i][j];
        int max = 1;
        for(int dir[]:dir){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
            if(matrix[nr][nc]>matrix[i][j]){
              max= Math.max(max,1+func(nr,nc,matrix,dp));
            }
        }
       return dp[i][j] =  max;
    }
}
