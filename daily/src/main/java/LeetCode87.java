import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode87 {

    class Solution {
        Map<String,Boolean> memo = new HashMap();
        public boolean isScramble(String s1, String s2) {
            if (memo.containsKey(s1+s2)){
                return memo.get(s1+s2);
            }
            // 长度不等，必定不能变换
            if (s1.length() != s2.length()) {
                return false;
            }
            // 长度相等，先特判下
            if (s1.equals(s2)) {
                return true;
            }
            // 看一下字符个数是否一致，不同直接return false
            int n = s1.length();

            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            boolean equal = Arrays.equals(chars1,chars2);
            if (!equal){
                memo.put(s1+s2,false);
                return false;
            }

            // 相同的话，开始判断判断，满足一个就能 return true
            for (int i = 1; i < n; i++) {
                boolean flag =
                        // S1 -> T1，S2 -> T2
                        (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                                // S1 -> T2，S2 -> T1
                                (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)));
                if (flag) {
                    memo.put(s1+s2,true);

                    return true;
                }
            }
            memo.put(s1+s2,false);
            return false;
        }
    }


}
