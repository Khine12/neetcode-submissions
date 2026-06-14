
class Solution {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int x : nums){

            set.add(x);
        }

        int best = 0;

        for(int x: set){

            if(!set.contains(x-1)){

                int current = x;

                int length = 1;

                while(set.contains(current+1)){

                    current++;

                    length++;
                }

                best = Math.max(best,length);
            }


        }

        return best;
    }
}
