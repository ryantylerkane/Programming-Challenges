class Solution {
    public boolean isHappy(int n) {
        
    int slow = n;
    int fast = n;
        
        while(fast != 1)
        {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
            
            if(slow==fast && fast!=1)
                return false;
        }
        return true;
    }
    
    private int squareSum(int n)
    {
        int temp;
        int total = 0;
        
        while(n != 0)
        {
            temp =n%10;
            total += temp*temp;
            n=n/10;
        }
        
        return total;
    }
}