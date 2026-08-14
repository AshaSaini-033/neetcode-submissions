class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        int i=0;
        Stack<Character> st = new Stack<>();

        while(i<n){
            char ch = s.charAt(i);
          if(ch=='[' || ch=='{'||ch=='(') st.push(ch);
          else{
            if (st.isEmpty()) {
                    return false;
                }
            if(ch==']'){
                if(st.peek()!='[')return false;
}
            else if(ch=='}'){
                if( st.peek()!='{')return false;
            }
              
            else if(ch==')'){
                if(st.peek()!='(')return false;
            
            }
            st.pop();
          }
          i++;
        }
        return st.isEmpty();
    }
}
