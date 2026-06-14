class Solution {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length-1;

        if(nums.length < 3){

            if(nums[0] == target){

                return 0;
            }
            else if(nums[1] == target){

                return 1;
            }
        }
        while(left < right){

            int mid = left + (right-left)/2;

            if(nums[mid] == target){

                return mid;
            }
            else if(nums[mid] > nums[right]){

                left = mid + 1;
            }
            else{

                right = mid;
            }
        }
        return -1;
    }
}
