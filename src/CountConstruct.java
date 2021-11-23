import java.util.HashMap;

public class CountConstruct {

    public static int countConstruct(String target, String[] wordBank, HashMap<String, Integer> memoList) {

        if(memoList.containsKey(target)) {
            return memoList.get(target);
        }

        int totalCount = 0;

        // Base case - check for an empty string
        if(target.equals("")) return 1;
        for(String prefix: wordBank) {
            if(target.startsWith(prefix)) {
                int count = countConstruct(target.substring(prefix.length()), wordBank, memoList);
                totalCount += count;
            }
        }
        memoList.put(target, totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        String[] wordBank = {
                "abc",
                "abcd",
                "abd",
                "d"
        };

        System.out.println(countConstruct(
                "abcd",
                wordBank,
                new HashMap<>()));
    }
}
