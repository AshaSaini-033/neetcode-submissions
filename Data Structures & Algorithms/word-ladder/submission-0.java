class Obj{
    String word;
    int cnt;
    public Obj(String word,int cnt){
        this.word = word;
        this.cnt = cnt;
    }
}
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    
        Queue<Obj> q= new LinkedList<>();
          Set<String> set = new HashSet<>();
          for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
          }
        q.offer(new Obj(beginWord,1));
        while(!q.isEmpty()){

            Obj obj = q.poll();
            String word = obj.word;
            int len = obj.cnt;

            if(word.equals(endWord))return len;
            for(int i=0;i<word.length();i++){

                for(char ch ='a';ch<='z';ch++){
                    char repword[] = word.toCharArray();
                    repword[i] = ch;
                    String newWord = new String(repword);
                    if(set.contains(newWord)){set.remove(newWord);
                    q.offer(new Obj(newWord,len+1));
                    }
                }
            }

        }
        return 0;
        
    }
}
