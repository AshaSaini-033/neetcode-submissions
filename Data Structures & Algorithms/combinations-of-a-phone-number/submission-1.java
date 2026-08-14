class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return ans;
        StringBuilder sb = new StringBuilder();
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
         hm.put('3',"def");
          hm.put('4',"ghi");
         hm.put('5',"jkl");
        hm.put('6',"mno");
         hm.put('7',"pqrs");
         hm.put('8',"tuv");
          hm.put('9',"wxyz");
        func(0,digits,sb,hm);
        return ans;
    }
    public void func(int idx,String digits,StringBuilder sb,HashMap<Character,String> hm){
        
        if(idx==digits.length()){
            ans.add(sb.toString());
            return;
        }
        char ch = digits.charAt(idx);
        String str = hm.get(ch);
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            func(idx+1,digits,sb,hm);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
