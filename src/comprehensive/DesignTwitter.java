package comprehensive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 355. 设计推特
 *
 * @author xieyu
 * @keywords: 优先队列 HashMap HashSet
 * @ideas:
 * @since 2022-3-30 11:42:01
 */
public class DesignTwitter {
    class Twitter {
        // 用户和推文的对应
        private Map<Integer, Tw> twMap;
        // 用户和关注列表的对应
        private Map<Integer, Set<Integer>> following;
        // 自增ts
        private int ts = 0;
        // 优先队列
        private PriorityQueue<Tw> queue = new PriorityQueue<>((o1, o2) -> o2.ts - o1.ts);

        public Twitter() {
            twMap = new HashMap<>();
            following = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            ts++;
            Tw tw = twMap.get(userId);
            if (tw == null) {
                tw = new Tw(tweetId, ts);
                twMap.put(userId, tw);
            } else {
                Tw newTw = new Tw(tweetId, ts);
                newTw.next = tw;
                twMap.put(userId, newTw);
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            queue.clear();
            Tw tw = twMap.get(userId);
            if (tw != null) {
                queue.offer(tw);
            }
            Set<Integer> followings = following.get(userId);
            if (followings != null) {
                for (int user : followings) {
                    tw = twMap.get(user);
                    if (tw != null) {
                        queue.offer(tw);
                    }
                }
            }

            int count = 0;
            while (!queue.isEmpty() && count < 10) {
                Tw one = queue.poll();
                res.add(one.id);
                if (one.next != null) {
                    queue.offer(one.next);
                }
                count++;
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }
            Set<Integer> set = following.get(followerId);
            if (set == null) {
                set = new HashSet<>();
                set.add(followeeId);
                following.put(followerId, set);
            } else {
                set.add(followeeId);
            }
        }

        public void unfollow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }
            Set<Integer> set = following.get(followerId);
            if (set == null) {
                return;
            }
            set.remove(followeeId);
        }

        private class Tw {
            public int id;
            public int ts;
            public Tw next;

            public Tw(int id, int ts) {
                this.id = id;
                this.ts = ts;
            }
        }
    }
}
