class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max_pile = 0; 

        for(int p : piles){

            max_pile = Math.max(max_pile,p);
        }

        int left = 1, right = max_pile;

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
