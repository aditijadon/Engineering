package Coding.array;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    static int getLongestConsecutiveSequence(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = {0,3,2,5,4,6,1,1};
        System.out.println(getLongestConsecutiveSequence(arr));
    }
}

// A consecutive sequence is a sequence of elements in which each element
// is exactly 1 greater than the previous element.
// The elements do not have to be consecutive in the original array.
