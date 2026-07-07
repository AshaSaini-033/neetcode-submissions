class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        int n = strs.length;
        HashMap<String,List<String>> hm = new HashMap<>();
        for(int i=0;i<n;i++){
        String key = stringsort(strs[i]);
            if(hm.containsKey(key)){
                hm.get(key).add(strs[i]);
            }else{
                ArrayList<String> list2 = new ArrayList<>();
list2.add(strs[i]);
hm.put(key, list2);
     
            }

        }
        for(List<String> value: hm.values()){
            list.add(value);
        }
        return list;
    }
    private String stringsort(String s){
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
