class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adjList.add(new ArrayList<>());
        }
        int len = times.length;
        for(int i=0;i<len;i++){
            adjList.get(times[i][0]).add(new Node(times[i][1],times[i][2]));
        }
        int arr[] = new int[n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[k] = 0;
        arr[0] = 0;

        //dijkstra algo
        boolean vis[] = new boolean[n+1];
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b)->a.dist-b.dist);
        minHeap.add(new Node(k,0));
        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            int dist = node.dist;
            int vertex = node.vertex;
            if(vis[vertex]) continue;
            vis[vertex] = true;
            arr[vertex] = dist;
             for(int i=0;i<adjList.get(vertex).size();i++){
                 Node adj = adjList.get(vertex).get(i);
                 if(adj.dist+dist<arr[adj.vertex]){
                    arr[adj.vertex]  = adj.dist+dist;
                    minHeap.add(new Node(adj.vertex,arr[adj.vertex]));
                 }
             }
            
        }
        int max = 0;
        for(int i=0;i<=n;i++){
            if(arr[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max,arr[i]);
        }
        return max;


    }
}
class Node{
    int vertex;
    int dist;
    Node(int vertex,int dist){
        this.vertex = vertex;
        this.dist = dist;
    }

}
