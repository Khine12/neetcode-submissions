class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length, maxArea = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i <=n; i++){

            int current_height = (i==n) ? 0 : heights[i];

            while(!stack.isEmpty() && current_height < heights[stack.peek()]){

                int mid = stack.pop();

                int height = heights[mid];

                int leftSmallerIndex = (stack.isEmpty()) ? -1 : stack.peek();

                int width = i-leftSmallerIndex-1;

                maxArea = Math.max(maxArea,height*width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
