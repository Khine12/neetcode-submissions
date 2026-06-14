class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;

        int l=0, r= n-1;

        while(l<=r){

            int mid = l + (r-l)/2;

            if(numbers[mid] == target) return new int[]{l-1,r-1};

            else if(numbers[mid]<target){

                l = mid+1;
            }
            else{

                r = mid-1;
            }

        }
        return new int[]{-1,-1};
    }
}
