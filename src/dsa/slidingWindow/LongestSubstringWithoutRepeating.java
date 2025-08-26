package dsa.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    static int findLongestSubstringWithoutRepeating(String s){
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for(int right = 0; right < s.length()-1; right++){
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "zxyzxyz";
        System.out.println("length = " + findLongestSubstringWithoutRepeating(s));
    }
}
