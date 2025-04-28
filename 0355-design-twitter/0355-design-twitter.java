class Twitter {

    private static int timestamp = 0; // global timestamp

    private class User {
        int id; // userId
        Set<Integer> followed; // HashSet
        Tweet tweetHead; // User LinkedList, to keep chain of all current User object Tweets

        public User(int id) {
            this.id = id;
            followed = new HashSet<>(); // new HashSet
            follow(id); // User should follow himself
            tweetHead = null; // No tweets as of now
        }

        public void follow(int id) {
            followed.add(id); // user started following id
        }

        public void unfollow(int id) {
            if ( id != this.id ) { // user cant unfollow himself
                followed.remove(id); // user unfollowed id
            }
        }

        public void post(int id) {
            Tweet newTweet = new Tweet(id); // A new Tweet is created
            newTweet.next = tweetHead; // the new tweet is added at the head of the current user tweet list
            tweetHead = newTweet; // Head is updated
        }

    }

    private class Tweet {
        int id;
        int time;
        Tweet next;

        // cOnstructor to create new tweet
        public Tweet(int id) {
            this.id = id;
            time = timestamp++; // incrementing global timestamp each time new tweet posted
            next = null;
        }
    }

    private Map<Integer, User> userMap; // A map to store userId and and his User class object

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if ( !userMap.containsKey(userId) ) { // If user doesn't exist
            User newUser = new User(userId); // create new User class object
            userMap.put(userId, newUser); // userId and new User object are added to HashMap
        }
        userMap.get(userId).post(tweetId); // Once user exists, get the User object, create new Tweet and add to User's existing Tweets
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new LinkedList<>(); // To store all the tweets oof all the users the current userId is following
        if ( !userMap.containsKey(userId) ) return newsFeed; // If userId doesn't exists return empty List

        Set<Integer> followedUsers = userMap.get(userId).followed; // HashSet to store all users, the current userId is following
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue<>(
            followedUsers.size(),
            (a, b) -> b.time - a.time
        ); 
        // Heap to store all the tweets of the users, the current userId is following
        // These tweets will be given priority based on the amount of followers each user have 
        // and the time the tweets have posted. Latest tweets have high priority
        
        for ( int user: followedUsers) {
            Tweet tweet = userMap.get(user).tweetHead; // get the head of the tweet LinkedList of the user being followed
            if ( tweet != null ) {
                tweetHeap.add(tweet);
            }
        }

        int count = 0;
        while ( !tweetHeap.isEmpty() && count < 10 ) {
            Tweet tweet = tweetHeap.poll();
            newsFeed.add(tweet.id); // add only the tweetId;
            count++;
            if ( tweet.next != null ) {
                tweetHeap.add(tweet.next);
            }
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if ( !userMap.containsKey(followerId) ) {
            User newUser = new User(followerId);
            userMap.put(followerId, newUser);
        }
        if ( !userMap.containsKey(followeeId) ) {
            User newUser = new User(followeeId);
            userMap.put(followeeId, newUser);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if ( userMap.containsKey(followerId) && followerId != followeeId ) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */