class Solution {
    public boolean validTree(int n, int[][] edges) {
       List<List<Integer>> list = new ArrayList<>();
       for(int i=0;i<n;i++){
        list.add(new ArrayList<>());
       }
       boolean vis[] = new boolean[n];

       for(int i=0;i<edges.length;i++){
        list.get(edges[i][0]).add(edges[i][1]);
        list.get(edges[i][1]).add(edges[i][0]);

       }

       int cnt =0;
       Queue<int[]> q = new LinkedList<>();
       q.offer(new int[]{0,-1});
       while(!q.isEmpty()){
       int arr[] = q.poll();
       cnt++;
       int node = arr[0];
       vis[node] = true;
       int parent = arr[1];

       for(int adj:list.get(node)){
        if(vis[adj]){
            if(parent!=adj) return false;
        }else{
            q.offer(new int[]{adj,node});
        }
       }
       }
       return cnt==n;
    }
}
