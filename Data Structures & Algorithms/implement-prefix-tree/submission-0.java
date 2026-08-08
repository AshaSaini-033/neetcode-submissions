class PrefixTree {
    public static Node root;
    public PrefixTree() {
             root = new Node();

    }

    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(word.charAt(i))){
                node.put(ch,new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
      for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
        if(!node.containsKey(word.charAt(i))) return false;
        node = node.get(ch);
      }
      return node.isEnd();
    }

    public boolean startsWith(String prefix) {

        Node node = root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))) return false;
            node= node.get(prefix.charAt(i));
        }
        return true;

    }
}
class Node{
    boolean flag=false;
    Node links[] = new Node[26];

    public boolean containsKey(char ch){
   return links[ch-'a']!=null;
    }
    public Node get(char ch ){
        return links[ch-'a'];
    }

    public boolean isEnd(){
        return flag;
    }
    public void setEnd(){
        flag = true;

    }
    public void put(char ch ,Node node){
        links[ch-'a'] = node;
    }

}
