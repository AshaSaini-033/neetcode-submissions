class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        func(0,s,list);
        return ans;
    }
    public void func(int idx,String str,List<String> list){
        if(idx == str.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<str.length();i++){
        String ss = str.substring(idx,i+1);
        if(isPalindrome(ss)){
            list.add(ss);
            func(i+1,str,list);
            list.remove(list.size()-1);
          }
        }
    
    }
    public boolean isPalindrome(String s){
        if(s.length()==0) return true;
        int i=0;
        int j = s.length()-1;
        while(i<=j){
      if(s.charAt(i)!=s.charAt(j)) return false;
        i++;
        j--;
    }
        return true;
    }
}
