import java.util.HashMap;

public class CanConstruct {

    public static boolean canConstruct(String target, String[] wordBank, HashMap<String, Boolean> memoList) {

        if(memoList.containsKey(target)) {
            return memoList.get(target);
        }

        // Base case - check for an empty string
        if(target.equals("")) return true;
        for(String prefix: wordBank) {
            if(target.startsWith(prefix)) {
                if(canConstruct(target.substring(prefix.length()), wordBank, memoList)) {
                    memoList.put(target, true);
                    return true;
                }
            }
        }
        memoList.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        String[] wordBank = {
                "ee",
                "eeeeeeeeeeeeeee",
                "eeeeeeeeeeeeeeeee",
                "eeeeeeeeeeeeeeeeeee"
        };

        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeff", wordBank, new HashMap<>()));
    }
}
