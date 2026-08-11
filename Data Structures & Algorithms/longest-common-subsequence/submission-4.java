class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        // if(l1<l2){
        //     String temp = text1;
        //     text1 = text2;
        //     text2 = temp;
        // }
        int dp[][] = new int[l1+1][l2+1];
        for(int i=0;i<l1+1;i++){
        Arrays.fill(dp[i],-1);
        }
        return func(0,0,text1,text2,dp);
    }
    public int func(int i,int j,String text1,String text2,int dp[][]){
        if(i>=text1.length()|| j>=text2.length()) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        //match 
         int match = 0;
         int notmatch = 0;
         char ch1 = text1.charAt(i);
         char ch2 = text2.charAt(j);
         if(ch1==ch2){
              match = 1+func(i+1,j+1,text1,text2,dp);
         }
          else  notmatch = Math.max(func(i+1,j,text1,text2,dp),func(i,j+1,text1,text2,dp));
        return dp[i][j]= Math.max(match,notmatch);

    }
}
