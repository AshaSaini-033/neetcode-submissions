class Solution {
    int n,m;
  
    public boolean exist(char[][] board, String word) {
         n = board.length;
        m = board[0].length;
          boolean vis[][] = new boolean[n][m];
           if(m==0 || n==0 || word.length()==0) return true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                   
                if(func(i,j,board,word,0,vis)) return true;
                }
            }
        }
        return false;
    }
    public boolean func(int i,int j,char board[][],String word,int idx,boolean vis[][]){
         if(word.length()==idx) return true;
        if(i>=n || j>=m || i<0 || j<0 || vis[i][j]||board[i][j]!=word.charAt(idx)) return false;
        vis[i][j]=true;
         
        boolean found = func(i+1,j,board,word,idx+1,vis)||func(i-1,j,board,word,idx+1,vis)||func(i,j+1,board,word,idx+1,vis)||func(i,j-1,board,word,idx+1,vis);
        vis[i][j] = false;
        return found;
    }
}
