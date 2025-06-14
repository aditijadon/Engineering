package Coding.dp.Knapsack;

public class CountOfSubset {
    private static int[][] dp;

    static int getCountOfSubsetDp(int[] arr, int sum, int n){
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }

//        if(arr[n-1]<=sum) --> return getCountOfSubsetDp(arr, sum-arr[n-1], n-1) || getCountOfSubsetDp(arr, sum, n-1)
//        if(arr[n-1]>sum) --> return getCountOfSubsetDp(arr, sum, n-1)

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        int sum = 8;
        int n = arr.length;
        dp = new int[n+1][sum+1];
        System.out.println("Count of Subsets (DP): " + getCountOfSubsetDp(arr, sum, n));
    }
}
