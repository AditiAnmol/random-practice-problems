public class DuplicateZeroes {

    public static void duplicateZeros(int[] arr) {
        //int zeroCounter = -1, index = -1;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0 && i < n) {
                i++;
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(arr);

    }
}
