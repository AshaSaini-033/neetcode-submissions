class Solution {
     int n,m;
      boolean p[][], a[][];
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
     m = heights[0].length;
      List<List<Integer>> list = new ArrayList<>();
      boolean pvis[][]= new boolean[n][m];
      p = new boolean[n][m];
       a = new boolean[n][m];
        boolean avis[][]=  new boolean[n][m];

     //pacific

     for(int i =0;i<n;i++){
     if(!pvis[i][0]) dfs(i,0,heights,0,pvis,p);
     }
     for(int j=0;j<m;j++){
        if(!pvis[0][j]) dfs(0,j,heights,0,pvis,p);

     }

     //atlantic
     for(int i =0;i<n;i++){
     if(!avis[i][m-1]) dfs(i,m-1,heights,0,avis,a);
     }
     for(int j=0;j<m;j++){
        if(!avis[n-1][j]) dfs(n-1,j,heights,0,avis,a);

     }

for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        if(a[i][j] && p[i][j]){
            List<Integer> sub = new ArrayList<>();
            sub.add(i);
            sub.add(j);
            list.add(sub);
        }

}
}


return list;

     

    }

    public void dfs(int i,int j,int heights[][],int prev,boolean vis[][],boolean p[][]){
        if(i<0||j<0|| i>n-1|| j>m-1 || (vis[i][j]) ||heights[i][j]<prev) return ;
         p[i][j] = true;
         vis[i][j] = true;
         prev = heights[i][j];
         dfs(i+1,j,heights,prev,vis,p);
         dfs(i,j+1,heights,prev,vis,p);
         dfs(i,j-1,heights,prev,vis,p);
         dfs(i-1,j,heights,prev,vis,p);



    }
}
