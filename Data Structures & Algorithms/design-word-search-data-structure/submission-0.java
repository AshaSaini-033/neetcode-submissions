class WordDictionary {
   public static Node root;
    public WordDictionary() {
root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
     for(int i=0;i<word.length();i++){
        char ch = word.charAt(i);
        if(!node.contains(ch)){
            //then put 
            node.put(ch,new Node());
        }
        node = node.get(ch);
     }
     node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
       return dfs(node,word,0);
    }
    public boolean dfs(Node node , String word,int idx){
        if(node==null) return false;

        if(idx==word.length()) return node.isEnd();
  char ch = word.charAt(idx);
        if(ch!='.'){
            if(!node.contains(ch)) return false;
            return dfs(node.get(ch),word,idx+1);
        }
        // '.' means any characte
        for(int i=0;i<26;i++){
            if(node!=null){
            if(dfs(node.links[i],word,idx+1)){
                return true;
            }
            }
        }
        return false;
    }
}
class Node{
    Node links[] = new Node[26];
    boolean flag = false;

    public void put(char ch,Node node){
       links[ch-'a'] = node;
    }
    public boolean contains(char ch){
        if(links[ch-'a']!=null) return true;
        else return false;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public boolean isEnd(){
        return flag;
    }
    public void setEnd(){
        flag = true;
    }

}