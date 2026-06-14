class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSub = nums[0];

        int currSub = 0;

        for(int num : nums){

            if(currSub < 0){

                currSub = 0;
            }

            currSub += num;

            maxSub = Math.max(maxSub, currSub);
        }

        return maxSub;
    }
}
