class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        
        int[] result = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i < n; i++){

            int left_boundry = i-k+1;

            if(!dq.isEmpty() && dq.peekFirst() < left_boundry){

                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){

                dq.pollLast();
            }

            dq.offer(i);

            if(i>= k-1){

                result[i-k+1] = nums[dq.peekFirst()];
            }

        }

        return result;
    }
}
