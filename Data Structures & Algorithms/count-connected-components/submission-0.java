class Solution {
  
    public int countComponents(int n, int[][] edges) {
 List<List<Integer>> list = new ArrayList<>();
       for(int i=0;i<n;i++){
        list.add(new ArrayList<>());
       }
       boolean vis[] = new boolean[n];

       for(int i=0;i<edges.length;i++){
        list.get(edges[i][0]).add(edges[i][1]);
        list.get(edges[i][1]).add(edges[i][0]);

       }
         Queue<Integer> q = new LinkedList<>();

       int cnt =0;

  

       for(int i=0;i<n;i++){
        if(vis[i]==false){
            cnt++;
            bfs(i,list,q,vis);
        }
       }
       return cnt;
       
      
    }

    public void bfs(int node,List<List<Integer>> list,Queue<Integer> q,boolean vis[]){
        q.offer(node);
        while(!q.isEmpty()){
            int x = q.poll();
            for(int adj:list.get(x)){
                if(!vis[adj]){
                    vis[adj] = true;
                    q.offer(adj);
                }
            }
        }

    }
}
