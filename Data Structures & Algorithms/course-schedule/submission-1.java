class Solution {

          HashSet<Integer> hs = new HashSet<>();
          int indegree[];
    Queue<Integer> q = new LinkedList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
           int n = numCourses;
        indegree = new int[n];
     
        for(int i=0;i<n;i++){
           list.add(new ArrayList<>());
        }
        int len = prerequisites.length;

        for(int i=0;i<len;i++){
          
                list.get(prerequisites[i][1]).add(prerequisites[i][0]);
                indegree[prerequisites[i][0]]++;
            
        }
   for(int i=0;i<n;i++){
    if(indegree[i]==0){
        q.offer(i);
    }
   
   }
    return bfs(list,n);
}

    public boolean bfs(List<List<Integer>> list,int n){
        int count =0;
    while(!q.isEmpty()){
        int size=q.size();
        while(size-->0){
       int x= q.poll();
           count++;
 
  //loop check 


   for(int i=0;i<list.get(x).size();i++){
    indegree[list.get(x).get(i)]--;
    if(indegree[list.get(x).get(i)]==0){
    q.offer(list.get(x).get(i));
    }
   }

    }}
    return count==n;

    }
}
