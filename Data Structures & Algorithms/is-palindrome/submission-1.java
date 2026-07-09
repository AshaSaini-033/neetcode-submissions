class Solution {
    public boolean isPalindrome(String s) {
        int i =0;
        String str = s.replaceAll("[^0-9a-zA-z]","").trim().toLowerCase();
        int j = str.length()-1;
        while(i<=j){
        char ch = str.charAt(i);
        char ch2 = str.charAt(j);
        if(ch!=ch2 ) return false;
        i++;
        j--;
        }
        return true;
    }
}
