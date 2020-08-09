class Solution {
    public int reverse(int x) {
        int curr;
        int total = 0;
        int oldTotal;
        while(x !=0)
        {
            curr = x % 10;
            oldTotal = total;
            total = total* 10 + curr;
            if((total -curr)/10 != oldTotal) //Reversing the operations should give us oldTotal unless Integer overflow/underflow has occured.
                return 0;
            x/=10;
        }
        
        return total;
        
    }
}