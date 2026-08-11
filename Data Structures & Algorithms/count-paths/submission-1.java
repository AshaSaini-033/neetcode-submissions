class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
   for(int i=0;i<m;i++){
         Arrays.fill(dp[i],-1);
   }
        return func(m-1,n-1,dp);
    }
    public int func(int m,int n,int dp[][]){
        if(m<0 || n<0) return 0;
       if(m==0 && n==0 ) return 1;
       if(dp[m][n]!=-1) return dp[m][n];
       //up
       int up = func(m-1,n,dp);

       int left = func(m,n-1,dp);
       return dp[m][n]= up+left;
    }
}
