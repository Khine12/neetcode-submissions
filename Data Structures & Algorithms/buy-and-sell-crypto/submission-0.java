class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(int price : prices){

            if(price < min){

                min = price;
            }
            else{

                int current = price-min;

                profit = Marh.max(current,profit);
            }

        }
        return profit;
    }
}
