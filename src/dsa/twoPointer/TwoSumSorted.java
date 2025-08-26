package dsa.twoPointer;

public class TwoSumSorted {
    static int[] findTwoSum(int[] arr, int target, int[] res){
        int left = 0, right = arr.length-1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                res[0] = arr[left];
                res[1] = arr[right];
            }
            else if(sum < target){
                left++;
            }
            else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2,4,5,6};
        int target = 7;
        int res[] = new int[2];
        System.out.println("[" + findTwoSum(arr,target,res)[0] + "," + findTwoSum(arr,target,res)[1]+"]");
    }
}
