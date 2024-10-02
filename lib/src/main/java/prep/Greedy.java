package prep;

import java.util.Comparator;
import java.util.PriorityQueue;

class Greedy {

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