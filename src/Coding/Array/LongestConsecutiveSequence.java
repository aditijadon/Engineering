package Coding.Array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    static int getLongestConsecutiveSequence(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longestSequence = 0;
        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentSequence = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequence++;
                    set.remove(currentNum);
                }
                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        int arr[] = {2,20,4,10,3,4,5};
        System.out.println(getLongestConsecutiveSequence(arr));
    }
}

// A consecutive sequence is a sequence of elements in which each element
// is exactly 1 greater than the previous element.
// The elements do not have to be consecutive in the original array.
