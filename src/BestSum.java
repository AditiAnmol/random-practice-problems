import java.util.ArrayList;
import java.util.List;

public class BestSum {

    public static List<Integer> bestSum(int targetSum, int[] numbers, List<Integer> memoList) {

        // Implement memoization
        if(memoList.contains()) {

        }

        List<Integer> bestCombination = null;

        // Check for base cases like
        // If target Sum is zero
        if(targetSum == 0) return new ArrayList<>();

        // If targetSum is less than zero
        if(targetSum < 0) return null;

        // Check for each valid case from the numbers array
        for(int num: numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderCombination = bestSum(remainder, numbers);
            if(null != remainderCombination) {
                remainderCombination.add(num);
                if(null == bestCombination || remainderCombination.size() < bestCombination.size()) {
                    bestCombination = remainderCombination;
                }
            }
        }
        return bestCombination;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 2};
        int targetSum = 8;

        System.out.println(bestSum(targetSum, numbers));
    }

}
