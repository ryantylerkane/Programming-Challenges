class Solution {

    
    public int fib(int n) {
        
      int memo[] = new int[n+1];
      return fibRec(n, new int[n+1]);
    }
    
    private int fibRec(int n, int memo[])
    {
         if(n==0)
           return 0;
        if(n==1)
            return 1;
        if(memo[n-1] ==0)
            memo[n-1] = fib(n-1);
        if(memo[n-2]==0)
            memo[n-2] = fib(n-2);
        
        memo[n] = memo[n-1] + memo[n-2];
        
        return memo[n];
    }
}