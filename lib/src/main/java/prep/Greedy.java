package prep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Greedy {

    // Rock jumping: IMC OA 
    public static double rockJumping(int width, int[] heights, int[] rocks, int maxEnergy, int maxJump) throws Exception {
        // let's see if we can jump at least on the first rock
        if (Math.pow(rocks[0], 2) > maxEnergy || rocks[0] > maxJump) return -1;

        // let's see if we can jump directly to the other side of the river
        if (Math.pow(width, 2) <= maxEnergy && width <= maxJump) return Math.pow(10, 9);

        int left = 0;
        int right = heights[heights.length - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            // we need only rocks with height above the current water level
            ArrayList<Integer> rocksLeft = new ArrayList<>();

            for (int idx = 0; idx < heights.length; idx++) {
                if (heights[idx] >= mid) {
                    for(int idy = idx; idy < heights.length; idy++) {
                        rocksLeft.add(heights[idy]);
                    }
                    break;
                }
            }

            boolean isPossible = isGoalReachable(width, rocksLeft, maxEnergy, maxJump);

            if (isPossible && left == right) {
                return mid;
            } else if (isPossible) {
                 left = mid;
            } else {
                right = mid - 1;
            }
        }
        throw new Exception("exception"); // not reachable
    }

    public static boolean isGoalReachable(int width, List<Integer> rocks, int maxEnergy, int maxJump) {
        int pos = 0;
        int energyLeft = maxEnergy;

        for (int idx = 0; idx < rocks.size(); idx ++) {
            if (Math.pow(rocks.get(idx) - pos, 2) > energyLeft || rocks.get(idx) - pos > maxJump) return false;

            energyLeft -= Math.pow(rocks.get(idx) - pos, 2);
            pos = rocks.get(idx);
        }

        // last jump
        return Math.pow(width - pos, 2) <= energyLeft && width - pos <= maxJump;
    }

    // Maximum Throughput problem - Citadel OA
    // https://www.fastprep.io/problems/citadel-get-max-throughput
    public static int maxProfit(int[] throughput, int[] costs, int budget) {
        int [] scales = new int[throughput.length];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparing((int[] other) -> other[0])
                .thenComparing(other -> other[1])
            );

        for (int idx = 0; idx < costs.length; idx++) {
            minHeap.add(new int[] {throughput[idx], idx});
        }

        while (budget >= 0) {
            // let's see if we can pay for the next scale before popping out. if we can't afford it, return.
            if (costs[minHeap.peek()[1]] > budget) return minHeap.poll()[0];
            
            int[] current = minHeap.poll();
            int service_idx = current[1];

            budget -= costs[service_idx];
            scales[service_idx] += 1;

            // new throughput is throughput[service_idx] * (1 + scales[service_idx])
            int new_throughput = scales[service_idx] * throughput[service_idx] + throughput[service_idx];
            // let's insert new item in the priority queue
            minHeap.add(new int[]{new_throughput, service_idx});
        }
        return minHeap.poll()[0];
    }
}