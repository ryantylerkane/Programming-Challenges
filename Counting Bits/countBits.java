class Solution {
    int memo[];
    public int[] countBits(int num) {
        memo = new int[num+1];
        if(num >=0)
            memo[0] = 0;
        
        for(int i=1; i < memo.length;i++)
        {
            if(i%2!=0) //odd number
                memo[i] = memo[i-1] +1;
            else if((Math.log(i)/Math.log(2))% 1==0) //Power of 2.
                memo[i] = 1;
            else //Even, but not a power of two.
                memo[i] = memo[i/2];
        }
        
        return memo;
    }
}