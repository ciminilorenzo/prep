Just random exercises taken from [FastPrep](https://www.fastprep.io/dashboard/problems), a website that collects real OAs from various companies. 

Some exercises don't have a public solution at the time of writing this, thus feel free to give me feedback whether you want to know more about a specific exercise or if you don't think my solution is the best approach. Moreover, solutions are not tested against any possible test case but only with those available in the problem description (look them up in test/).

The listed exercises below are not (still?) present within FastPrep but present in this repo:
<details>
<summary>Rock jumping: IMC OA | Greedy </summary>
  
You need to cross a river by jumping on rocks, and some rocks may get submerged as water rises. Each rock has a height, 
and the water level starts to rise after you make your first jump. The goal is to determine the maximum water level such
that you can still jump across the river without exceeding the maximum jump distance (maxJump) and total energy (maxEnergy).
        
Return urn 10^9 if it's always possible, -1 if it's never possible or the maximum water level.
        
Constraints:
1. You can jump a maximum of maxJump distance at once.
2.	The total energy used in your jumps cannot exceed maxEnergy. The energy to jump between two positions is 
    equal to the square of the distance.
3.	A rock is submerged if the water level is greater than its height, making it unusable for jumps.

Inputs:
1. width: The width of the river (distance from x = 0, where you start, x = width).
2. numRocks: Number of rocks in the river.
3. maxJump: Maximum jump distance.
4. maxEnergy: Maximum total energy you can use.
5. Two arrays: x: The x-coordinates of the rocks; height: The height of each rock (in non-decreasing order)
</details>

<details>
<summary>Friend recommendation system : IMC OA | Graphs </summary>
  
There are `n` users, labelled from 0 up to `n` - 1, and `m` friendships represented as a 2D array where the Ith friendship is a connection between users `friendships[i][0]` & `friendships[i][1]`.

User `x` is suggested as a friend to user `y` if they are not friends and share the maximum number of common friends. If there are multiple such users, the one with the minimum index is suggested. 

Given `n` friends and m friendships, find the index of the user that should be recommended as a new friend to each user. If there is not any recommendation, return -1.
</details>
    