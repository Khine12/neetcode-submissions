class Solution {
    public int maxArea(int[] heights) {

        int left = 0, right = heights.length-1;

        int max_water = 0;

        while(left<right){

            int current = (right-left)*Math.min(heights[left],heights[right]);

            if(max_water < current) max_water=current;

            if(heights[left] < heights[right]){

                left++;
            }
            else{
                right--;
            }
        }
        return max_water;
    }
}
