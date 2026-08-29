class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1<n2) return 0;
        int dp[][] = new int[n1+1][n2+1];
        for(int i=0;i<n1+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return  solve(s,t,n1-1,n2-1,dp);


        
    }
    public int solve(String s,String t,int i,int j,int dp[][]){
         if(j<0) return 1;
         if(i<0) return 0;
         if(dp[i+1][j+1]!=-1) return dp[i+1][j+1];
         if(s.charAt(i)==t.charAt(j)){
            return dp[i+1][j+1]= solve(s,t,i-1,j-1,dp)+solve(s,t,i-1,j,dp);
         }
         else return dp[i+1][j+1]= solve(s,t,i-1,j,dp);
    }
}
