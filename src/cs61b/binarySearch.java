package cs61b;

import java.util.Arrays;

public class binarySearch {
    public static int binary(int[] nums, int target) {
        Arrays.sort(nums);
        int r = nums.length - 1;
        int l = 0;
        if (l == r) {
            return nums[r] == target ? r : -1;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(target > nums[mid]){
                l = mid + 1;
            }else if(target < nums[mid]){
                r = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(binary(nums, 3));
    }
}
