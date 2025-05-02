package DsAlgo.DP;

import java.util.Arrays;
import java.util.Map;

public class MinimumSubsetSumDiff {
    private static int[][] dp;
    private static int minDiff = 0;

    static int getMinSubsetDiffRecursion(int[] arr, int sum, int n){
        if(sum == 0 || n == 0) return 0;

        if(arr[n-1]<sum){
            return minDiff = Math.min(minDiff, Math.abs(getMinSubsetDiffRecursion(arr, sum-arr[n-1], n-1) - getMinSubsetDiffRecursion(arr, sum, n-1)));
        }

        else {
            return minDiff = Math.min(minDiff,getMinSubsetDiffRecursion(arr, sum, n-1));
        }
    }

    static int getMinSubsetDiffDP(int[] arr, int sum, int n){
        return 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,6,11,5};
        int n = 4;
        int sum = Arrays.stream(arr).sum();
        dp = new int[n+1][sum+1];
        System.out.println("Min Sum Diff (Recursion): " + getMinSubsetDiffDP(arr, sum, n));
        System.out.println("Min Sum Diff (DP): " + getMinSubsetDiffDP(arr, sum, n));
    }
}
