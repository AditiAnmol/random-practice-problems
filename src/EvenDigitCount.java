public class EvenDigitCount {

    public static int findNumbers(int[] nums) {
        int evenDigitNum = 0;

        for(int num: nums) {
            evenDigitNum = String.valueOf(num).length() % 2 == 0 ? ++evenDigitNum : evenDigitNum;
        }

        return evenDigitNum;
    }

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }

}
