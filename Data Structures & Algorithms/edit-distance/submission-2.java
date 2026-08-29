class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int dp[][] = new int[n1][n2];
        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(word1,word2,n1-1,n2-1,dp);
    }
    //delete i-1,j
    //insert i,j-1
    //replace i-1,j-1
    private int solve(String word1,String word2,int i,int j,int dp[][]){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)) return dp[i][j]= solve(word1,word2,i-1,j-1,dp);
        else{
         int x= solve(word1,word2,i-1,j,dp);
           int y  =solve(word1,word2,i,j-1,dp);
           int z = solve(word1,word2,i-1,j-1,dp);
           return dp[i][j] =  Math.min(x,Math.min(y,z))+1;
        }
    }
}
