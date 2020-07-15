class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length<=1)
            return 0;
        
        int currentMin = Integer.MAX_VALUE;
        int currentProfit = 0;
        int totalProfit = 0;
        int sellToday = 0;
        
        for(int i=0; i < prices.length;i++)
        {
            sellToday = prices[i] - currentMin;
            if(sellToday<currentProfit) //Lower stock avaialble for purchase/the selling price price is starting to drop.
            {
                    totalProfit+=currentProfit;
                    currentProfit=0;
                    currentMin = prices[i];         
            }
            else //Stock price rising; update maxiumum price that the stock can be sold at.
            {
                currentProfit = sellToday;
            }
            
        }
        
        return totalProfit+currentProfit;
    }
}