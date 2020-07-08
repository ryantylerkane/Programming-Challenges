class Solution {
    public int maxProfit(int[] prices) {
        
        int bestProfit = 0;
        int cheapest = Integer.MAX_VALUE;
        int currentProfit = 0;
        
        for(int price:prices)
        {
            currentProfit = price-cheapest;
            
            if(price < cheapest)
            {
                cheapest = price;
            }
            else if(currentProfit > bestProfit)
            {
                bestProfit = currentProfit;
            }
        }
        
        return bestProfit;
        
    }
}