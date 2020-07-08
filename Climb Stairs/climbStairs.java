class Solution {
    public int climbStairs(int n) {
        
        int memo[] = new int[n+1];
        memo[0] = 1;
        
        return climb(n, memo);
    }
    
    private int climb(int n, int[] memo)
    {
           if(n==0)
            return memo[0];
        else if(n < 0)
            return 0;
        
        if(memo[n] == 0)
        {
            memo[n] = climb(n-2, memo) + climb(n-1, memo);
        }
        return memo[n];
    }
}