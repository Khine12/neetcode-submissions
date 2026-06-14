class Solution {
    public int trap(int[] height) {

        int n = height.length;

        if(n < 3) return 0;

        int water = 0;

        int[] LeftMax = new int[n];

        int[] RightMax = new int[n];

        LeftMax[0] = height[0];

        for(int i=1; i<n; i++){
            
            LeftMax[i] = Math.max(LeftMax[i-1],height[i]);
        }

        RightMax[n-1] = height[n-1];

        for(int i=n-2; i>=0; i--){

            RightMax[i] = Math.max(RightMax[i+1],height[i]);
        }

        for(int i=0; i<n; i++){

            int level = Math.min(LeftMax[i],RightMax[i]) - height[i];

            water += level;
        }

        return water;
    }
}
