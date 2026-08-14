class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st  = new Stack<>();
        for(int i=0;i<n;i++){
           if(!tokens[i].equals("*")&&(!tokens[i].equals("+"))&&!(tokens[i].equals("-"))&&(!tokens[i].equals("/"))){
            int x = Integer.parseInt(tokens[i]);
            st.push(x);
           }else{
            int t1 = st.pop();
            int t2 = st.pop();
            if(tokens[i].equals("*"))st.push(t2*t1);
              if(tokens[i].equals("+"))st.push(t2+t1);
                if(tokens[i].equals("-"))st.push(t2-t1);
                  if(tokens[i].equals("/"))st.push(t2/t1);
           }
        }
        return st.peek();
    }
}
