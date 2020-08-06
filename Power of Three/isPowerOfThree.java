class Solution {
    public boolean isPowerOfThree(int n) {
        
        double result = (double)n;
        if(Math.log10(result)/Math.log10(3) % 1==0)
            return true;
        else
            return false;
        
        
    }
}