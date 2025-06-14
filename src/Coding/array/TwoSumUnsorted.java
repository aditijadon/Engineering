package Coding.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumUnsorted {
    static int[] findTwoSum(int[] arr, int target, int[] res){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int remainder = target - arr[i];
            if(map.containsKey(remainder)){
                res[0]=map.get(remainder);
                res[1]=i;
            }
            map.put(arr[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {5,4,2,6};
        int target = 7;
        int res[] = new int[2];
        System.out.println("[" + findTwoSum(arr,target,res)[0] + "," + findTwoSum(arr,target,res)[1]+"]");
    }
}
