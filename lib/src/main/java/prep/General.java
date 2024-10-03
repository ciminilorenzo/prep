package prep;

// Solutions to exercises which are not related to any DS.
public class General {

    // https://www.fastprep.io/problems/ziprecruiter-caught-fish
    public static int maximumFishCaught(int[] fish, int baits[]) {
        int res = 0;
        int fishIdx = fish.length - 1;
        int baitIdx = baits.length - 1;
        int baitUsage = 0;

        // this is O(max(fish.length, baits.length))
        while (fishIdx >= 0 && baitIdx >= 0) {
            if (baits[baitIdx] < fish[fishIdx]) {
                res += 1;
                baitUsage += 1;
                fishIdx -= 1;
            } else {
                baitUsage = 3; // to force the bait idx update without duplicating code
            }   

            if (baitUsage == 3) {
                baitUsage = 0;
                fishIdx -= 1;
            }
        }

        return res;
    }
}