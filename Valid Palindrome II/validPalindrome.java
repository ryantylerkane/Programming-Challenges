class Solution {
    public boolean validPalindrome(String s) {
    int beg = 0;
    int end = s.length()-1;
    while(beg < end)
    {
        if(s.charAt(beg) != s.charAt(end))
        {
            return isPalindrome(s, beg+1,end) || isPalindrome(s, beg, end-1);
        }
        else
        {
            beg++;
            end--;
        }
    }  
        
    return true;
        
    }
    
   private boolean isPalindrome(String s, int beg, int end)
    {
        while(beg < end)
        {
            if(s.charAt(beg) != s.charAt(end))
            {
               return false;
            }
            else
            {
                beg++;
                end--;
            }
        }
        
        return true;
    }
}