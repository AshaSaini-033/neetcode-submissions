class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int[] state= new int[26];
    Stack<Integer> stack = new Stack<>();
    
    public String foreignDictionary(String[] words) {
       
        int n = words.length;
        for(int i=0;i<26;i++){
            graph.add(new ArrayList<>());
        }
        boolean[] present = new boolean[26];
        for(String word:words){
            for(char ch : word.toCharArray()){
                present[ch-'a'] = true;
            }
        }

        for(int i=0;i<n-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];

            int len = Math.min(w1.length(),w2.length());
            boolean found = false;
            for(int j=0;j<len;j++){
                int u = w1.charAt(j)-'a';
                int v = w2.charAt(j)-'a';
                if(u!=v){
                    found = true;
                    graph.get(u).add(v);
                    break;
                }
            }

            if(found!=true && w1.length()>w2.length()){
                return "";
            }
        }

        //state 0 = unvisited
        //1 = currently visited in a dsf
        //2 = completed visited

        for(int i=0;i<26;i++){
            if(present[i] && state[i]==0){
                if(!dfs(i)){
                    return "";
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            int node = stack.pop();
            sb.append((char)('a'+node));
        }

        return sb.toString();

      
    }

    boolean dfs(int node){
        if(state[node]==1)return false;
        if(state[node]==2) return true;
        state[node]=1;
        for(int nei: graph.get(node)){
            if(!dfs(nei)) return false;

        }

        state[node] = 2;
        stack.push(node);
        return true;

    }
}
