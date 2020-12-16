class Solution {
public int fib(int n) {
    
    if(n==0)
        return 0;
    if(n==1)
        return 1;
    
    int currMinOne = 1;
    int currMinTwo = 0;
    int curr=-1;
    
    for(int i=2; i <= n;++i)
    {
        curr = currMinOne + currMinTwo;
        currMinTwo = currMinOne;
        currMinOne = curr;
    }
    
    return curr;
}   
}