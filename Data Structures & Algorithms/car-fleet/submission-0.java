class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i < n; i++){

            int time = (target-position[i])/speed[i];

            if(!stack.contains(time)){

                stack.push(time);
            }
        }

        return stack.size();
        
    }
}
