package prep;

import static java.lang.Math.max;

public class Backtracking {

    // https://www.fastprep.io/problems/openai-maximize-the-hits
    // Binary search to search the idx (within the walls array) where to start. After that, backtracking to 
    // prove any possible path. A greedy solution won't let me consider long-term choices that could lead
    // to optimal solution.
    public static int maxWallHits(float[] walls, int[] thickness, int maxEnergy) {
        int left = 0;
        int right = walls.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (walls[mid] > 0.0) {
                right = mid - 1;
            }
            else if (walls[mid] < 0.0) {
                left = mid + 1;
            }
        }

        int start_idx = walls[left] > 0.0 ? left : left + 1;
        return backtracking(start_idx, walls, thickness, maxEnergy);
    }

    public static int backtracking(int idx, float[] walls, int[] thickness, int maxEnergy) {
        int myCoordinate = (int) walls[idx];
        int [] dirs = new int[]{1, -1}; 
        int res = 0;

        for (int dir : dirs) {
            if (idx + dir < 0 || idx + dir >= walls.length) continue;

            int nextWallCoordinate = (int) walls[idx + dir];
            int energyRequiredToMove = (int) Math.abs(myCoordinate - nextWallCoordinate);
            int energyRequiredToHit = (int) thickness[idx + dir];

            if (maxEnergy >= energyRequiredToHit + energyRequiredToMove) {
                res = max(res, 1 + backtracking(idx + dir, walls, thickness, maxEnergy - (energyRequiredToHit + energyRequiredToMove)));
            } 
        }
        return res;
    }
}