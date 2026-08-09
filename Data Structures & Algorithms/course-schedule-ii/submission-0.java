class Solution {

int ans[];
Queue<Integer> q = new LinkedList<>();
int indegree[];
    public int[] findOrder(int numCourses, int[][] prerequisites) {
ans = new int[numCourses];
indegree = new int[numCourses];
List<List<Integer>> list = new ArrayList<>();

for(int i=0;i<numCourses;i++){
    list.add(new ArrayList<>());
}
for(int i=0;i<prerequisites.length;i++){
    int neigh = prerequisites[i][0];
    int node = prerequisites[i][1]; 

    indegree[neigh]++;

    list.get(node).add(neigh);

}
for(int i=0;i<list.size();i++){
if(indegree[i]==0) q.offer(i);
}
 ans = bfs(list,numCourses);
 return ans;
    }

    public int[] bfs(List<List<Integer>> list ,int n){
        int count=0;
        int k=0;
        while(!q.isEmpty()){
            int x = q.poll();
            ans[k] = x;
            count++;
            for(int i=0;i<list.get(x).size();i++){
                int neigh = list.get(x).get(i);
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.offer(neigh);
                }
            }
            k++;

        }
        if(count==n) return ans;
        else return new int[]{};
    }
}
