import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestSum {

    public static List<Integer> bestSum(int targetSum, int[] numbers, HashMap<Integer, List<Integer>> memoList) {

        // Implement memoization to fetch the already calculated targetSums
        if(memoList.containsKey(targetSum)) {
            return memoList.get(targetSum);
        }

        // Check for base cases like
        // If target Sum is zero
        if(targetSum == 0) return new ArrayList<>();

        // If targetSum is less than zero
        if(targetSum < 0) return null;

        // Check for each valid case from the numbers array
        List<Integer> bestCombination = null;
        for(int num: numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderCombination = bestSum(remainder, numbers, memoList);
            if(null != remainderCombination) {
                // Important as previous memory is being reused - all old values are pre-stored which caused the issue
                List<Integer> tempCombination = new ArrayList<>(remainderCombination);
                tempCombination.add(num);
                if(null == bestCombination || tempCombination.size() < bestCombination.size()) {
                    bestCombination = tempCombination;
                }
            }

        }

        // Add each targetSum to memoList
        memoList.put(targetSum, bestCombination);
        return bestCombination;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 50, 100};
        int targetSum = 1000;

        System.out.println(bestSum(targetSum, numbers, new HashMap<>()));
    }

}
