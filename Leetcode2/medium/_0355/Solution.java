package medium._0355;

import java.net.Inet4Address;
import java.util.*;

class Twitter {
    private Map<Integer, List<Integer>> userTweets;
    private Map<Integer, Set<Integer>> userFollows;
    private Map<Integer, Long> tweetOrder;
    private long order;
    private static final int LIMIT = 10;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userTweets = new HashMap<>();
        userFollows = new HashMap<>();
        tweetOrder = new HashMap<>();
        order = 0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Integer> tweets = userTweets.computeIfAbsent(userId, x -> new LinkedList<>());
        if (tweets.size() == LIMIT) {
            tweets.remove(tweets.size() - 1);
        }
        tweets.add(0, tweetId);
        tweetOrder.put(tweetId, order++);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweetsForReturn = new ArrayList<>();
        Iterator<Integer> iter = userTweets.computeIfAbsent(userId, x -> new LinkedList<>()).iterator();
        for (int i = 0; i < LIMIT && iter.hasNext(); i++) {
            tweetsForReturn.add(iter.next());
        }
        // 合并多个链表，推文的order越大则在链表中越靠前
        for (int uid : userFollows.computeIfAbsent(userId, x -> new HashSet<>())) {
            if (uid == userId) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            iter = userTweets.computeIfAbsent(uid, x -> new LinkedList<>()).iterator();
            // 两个用户推文链表的表头
            Integer tweet1 = tweetsForReturn.isEmpty() ? null : tweetsForReturn.get(0);
            Integer tweet2 = iter.hasNext() ? iter.next() : null;
            for (int cnt = 0; (tweet1 != null || tweet2 != null) && cnt < LIMIT; cnt++) {
                if (tweet1 != null && tweet2 != null) {
                    if (tweetOrder.get(tweet1) > tweetOrder.get(tweet2)) {
                        tmp.add(tweet1);
                        tweetsForReturn.remove(0);
                        tweet1 = tweetsForReturn.isEmpty() ? null : tweetsForReturn.get(0);
                    } else {
                        tmp.add(tweet2);
                        tweet2 = iter.hasNext() ? iter.next() : null;
                    }
                } else if (tweet2 == null) {
                    tmp.add(tweet1);
                    tweetsForReturn.remove(0);
                    tweet1 = tweetsForReturn.isEmpty() ? null : tweetsForReturn.get(0);
                } else {
                    tmp.add(tweet2);
                    tweet2 = iter.hasNext() ? iter.next() : null;
                }
            }
            tweetsForReturn = tmp;
        }
        return tweetsForReturn;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        userFollows.computeIfAbsent(followerId, x -> new HashSet<>()).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        userFollows.computeIfAbsent(followerId, x -> new HashSet<>()).remove(followeeId);
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
public class Solution {
    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1,5);
        obj.follow(1,2);
        obj.follow(2,1);
        List<Integer> para1 = obj.getNewsFeed(2);
        obj.postTweet(2,6);
        List<Integer> para2 = obj.getNewsFeed(1);
        List<Integer> para3 = obj.getNewsFeed(2);
    }
}