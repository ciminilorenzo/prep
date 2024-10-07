package prep;

import static java.lang.Math.min;
import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    // https://www.fastprep.io/problems/amazon-find-subarray-with-minimum-distinct-integers
    public static int findSubarrayWithMinimumDistinctIntegers(int[] array, int series1, int series2) {
        if (series1 == series2) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == series1) {
                    return 1;
                }
            }
            return 0;
        }       

        boolean series1IsFound = false;
        boolean series2IsFound = false;
        int firstElemFoundPos = -1;
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < array.length; i++) {
            if ((array[i] == series1 && series2IsFound) || array[i] == series2 && series1IsFound) {
                res = min(res, findDistinctElemsInRange(array, firstElemFoundPos, i));
                
                if (array[firstElemFoundPos] == series1) series1IsFound = false;
                if (array[firstElemFoundPos] == series2) series2IsFound = false;    

                firstElemFoundPos = i;
            } else if (array[i] == series1) {
                series1IsFound = true;
                firstElemFoundPos = i;
            } else if (array[i] == series2) {
                series2IsFound = true;
                firstElemFoundPos = i;
            }
        }
        return res;
    }

    public static int findDistinctElemsInRange(int[] array, int start, int end) {
        Set<Integer> foundItems = new HashSet<>();

        for (int i = start; i <= end; i++) {
            foundItems.add(array[i]);
        }
        return foundItems.size();
    }
}