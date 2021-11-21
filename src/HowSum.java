import java.util.ArrayList;
import java.util.List;

public class HowSum {

    public static List<Integer> howSum(int targetSum, int[] numbers, List<Integer> memoList) {

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
                remainderResult.add(num);
                return remainderResult;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 2};
        int targetSum = 8;

        System.out.println(howSum(targetSum, numbers, new ArrayList<>()));
    }

}
