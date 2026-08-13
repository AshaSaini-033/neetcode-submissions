class tweet{
    int tweetId;
    int cnt;
    public tweet(int tweetId,int cnt){
        this.tweetId = tweetId;
        this.cnt = cnt;
    }
}
class Twitter {
    int cnt =0;
    

      tweet tw = new tweet(0,0);
      HashMap<Integer, List<tweet>> user = new HashMap<>();
      HashMap<Integer,Set<Integer>> follow = new HashMap<>();



    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
  
    if(!user.containsKey(userId)){
      
          user.put(userId,new ArrayList<>());
    }
    user.get(userId).add(new tweet(tweetId,cnt++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
       PriorityQueue<tweet> pq = new PriorityQueue<>((a,b)->b.cnt-a.cnt);
       Set<Integer> people = new HashSet<>();
       people.add(userId);
       if(follow.containsKey(userId)){
        people.addAll(follow.get(userId));
       }
            for(int id:people){ //going to every user like jisko follow kr rkha hai 
                if(user.containsKey(id)){ // agar uske follower ne kucch post kiya hai vo user map m hoga 
                    for(tweet t :user.get(id)){//all tweets of that user add in pq
                    pq.add(t);

                    }
                }
            }
            List<Integer> ans  = new ArrayList<>();
            while(pq.size()!=0 && ans.size()<10){
                ans.add(pq.poll().tweetId);
            }
            return ans;

    }
    
    public void follow(int followerId, int followeeId) {
        if(!follow.containsKey(followerId)){
            Set<Integer> set = new HashSet<>();
        
            follow.put(followerId,set);
        }
          follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follow.containsKey(followerId)){
            follow.get(followerId).remove(followeeId);                                                                                                  }
    }
}
