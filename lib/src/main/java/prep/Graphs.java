package prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graphs {
    
    // Friend recommendation prototype (look the problem descrition up in the README)
    public static int[] friendRecommendationSystem(int n, int m, int[][] friendships) {
        Map<Integer, Set<Integer>> graph = new HashMap<>(friendships.length);

        for (int[] friendship : friendships) {
            int from = friendship[0];
            int to = friendship[1];

            graph.computeIfAbsent(from, k -> new HashSet<>()).add(to);
            graph.computeIfAbsent(to, k -> new HashSet<>()).add(from);
        }

        int[] result = new int[n];

        for (int currentUser = 0; currentUser < n; currentUser++) {
            Map<Integer, Integer> currentUserFriendsFriends = new HashMap<>();
            int recommendedIndex = -1;
            int recommendedValue = -1;

            for (int friend : graph.get(currentUser)) {
                for (int friendOfFriend : graph.get(friend)) {
                    // it's an undirected graph, so skip the current user from the list of friends of friends.
                    if (friendOfFriend == currentUser) continue;
                    
                    // no friends of friends who are friend of current user are allowed.
                    if (graph.get(friendOfFriend).contains(currentUser)) continue;
                    
                    if (! currentUserFriendsFriends.containsKey(friendOfFriend)) {
                        currentUserFriendsFriends.put(friendOfFriend, 1);
                    } else {
                        currentUserFriendsFriends.put(friendOfFriend, currentUserFriendsFriends.get(friendOfFriend) + 1);
                    }

                    int currentVal = currentUserFriendsFriends.get(friendOfFriend);

                    if (currentVal == recommendedValue && friendOfFriend < recommendedIndex) {
                        recommendedIndex = friendOfFriend;
                    } else if (currentVal > recommendedValue) {
                        recommendedIndex = friendOfFriend;
                        recommendedValue = currentVal;
                    }
                }
            }

            result[currentUser] = recommendedIndex;
        }
        
        return result;
    } 
}
