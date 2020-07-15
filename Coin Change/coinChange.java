class Solution {
    
    private int memo[];
    
    public int coinChange(int[] coins, int amount) {
        
        if(coins.length==0)
            return -1;
        if(amount<=0)
            return 0;
        
        memo = new int[amount+1];
        
        return processCoin(coins, amount);
    }
    
    private int processCoin(int[] coins, int amount)
    {
        
        if(amount < 0)
            return -1;
        if(memo[amount] >0)
            return memo[amount];
        if(amount==0)
            return 0;
        
        int minimum = Integer.MAX_VALUE;
            
        for(int coin: coins)
        {
            int temp = processCoin(coins, amount-coin);
            if(temp < minimum && temp >=0)
            {
                minimum = temp+1;
            }     
        }
        
        if(minimum==Integer.MAX_VALUE)
            minimum = -1;
        
        memo[amount] = minimum; 
        return memo[amount];
    }
}