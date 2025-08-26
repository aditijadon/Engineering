package dsa.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    while (left < right && arr[left] == arr[left + 1])
                        left++; // Skip duplicates for left
                    while (left < right && arr[right] == arr[right - 1])
                        right--; // Skip duplicates for right
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}

// Approach : Sort + 2 pointer