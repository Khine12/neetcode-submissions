class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1, right = 0;

        for(int p : piles){

            right = Math.max(right,p);
        }

        long hours = 0;

        while(left<right){

            int mid = left + (right-left)/2;

            for(int p : piles){

                hours += p/mid + (p%mid==0 ? 0 : 1);
            }

            if(hours <= h){

                right = mid;
            }
            else{

                left = mid + 1;
            }

        }
        return left;
    }
}
