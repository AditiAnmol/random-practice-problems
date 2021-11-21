import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HowSum {

    public static List<Integer> howSum(int targetSum, int[] numbers, HashMap<Integer, List<Integer>> memoList) {

        // Implement memoization tp fetch the already calculated targetSums
        if(memoList.containsKey(targetSum)) {
            return memoList.get(targetSum);
        }

        // Check for base cases like
        // If target Sum is zero
        if(targetSum == 0) return new ArrayList<>();

        // If targetSum is less than zero
        if(targetSum < 0) return null;

        // Check for each valid case from the numbers array
        for(int num: numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSum(remainder, numbers, memoList);
            if(null != remainderResult) {
                List<Integer> tempResult = new ArrayList<>(remainderResult);
                tempResult.add(num);
                memoList.put(targetSum, tempResult);
                return tempResult;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5};
        int targetSum = 8;

        System.out.println(howSum(targetSum, numbers, new HashMap<>()));
    }

}
