package prep;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BinarySearch {
    
    // rockJumping - IMC (look the problem's description up in the README)
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

    private static boolean isGoalReachable(int width, List<Integer> rocks, int maxEnergy, int maxJump) {
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

    // https://www.fastprep.io/problems/amazon-num-of-suitable-places
    public static int numberOfSuitablePlaces(int[] center, int d) {
        Arrays.sort(center);

        int leftExtreme = findLeftExtreme(center, d);
        int rightExtreme = findRightExtreme(center, d);

        if (leftExtreme == 1_000_000_000 - 1 || rightExtreme == 1_000_000_000 + 1) {
            return 0;
        }

        return rightExtreme - leftExtreme + 1;
    }

    public static int findLeftExtreme(int[] center, int d) {
        int left = - 1_000_000_000;
        int right = center[center.length - 1];

        while (left < right) {
            int mid = (left + right - 1) / 2;

            boolean isSpotSuitable = isSpotSuitable(mid, center, d);

            if (isSpotSuitable) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return isSpotSuitable(right, center, d) ? right : 1_000_000_000 - 1;
    }

    public static int findRightExtreme(int[] center, int d) {
        int left = center[0];
        int right = 1_000_000_000;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            boolean isSpotSuitable = isSpotSuitable(mid, center, d);
            
            if (isSpotSuitable) {
                left = mid;
            } else {
                right = mid - 1;
            }
            
        }
        
        return isSpotSuitable(left, center, d) ? left : 1_000_000_000 + 1;
    }
    
   public static boolean isSpotSuitable(double pos, int[] center, int d) {
       for (int spot : center) {
           d -= 2 * Math.abs(pos - spot);

           if (d < 0) return false;
       }
       
       return true;
   }
}