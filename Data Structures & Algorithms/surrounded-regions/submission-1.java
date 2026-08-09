class Solution {
    public void solve(char[][] board) {
        int n = board.length;
       int direction[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && (i==0|| j==0 || i==n-1 || j==m-1)){
                    vis[i][j] = true;
                    board[i][j] = '#';
                    q.offer(new int[]{i,j});}

            }
        }

        while(!q.isEmpty()){
       int curr[] = q.poll();
       int r = curr[0];
       int c = curr[1];
       for(int dir[]: direction){
        int nr = r+dir[0];
        int nc = c+dir[1];
        if(nr<0 || nc<0|| nr>=n|| nc>=m || vis[nr][nc]||board[nr][nc]=='X') continue;
        if(board[nr][nc]=='O'){
            vis[nr][nc]=true;
            board[nr][nc] = '#' ;
            q.offer(new int[]{nr,nc});
            }
       }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
             if(board[i][j]=='#') board[i][j] ='O';
             else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        
    }
}
