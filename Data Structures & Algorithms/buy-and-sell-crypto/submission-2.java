class Solution {
    public int maxProfit(int[] prices) {
        
        int min_max = Integer.MAX_VALUE;

        int profit = 0;

        for(int price : prices){

            if(price < min_max){

                min_max = price;

            }
            else{

                int current = price - min_max;

                profit = Math.max(current,profit);
            }
        }
        return profit;
    }
}
