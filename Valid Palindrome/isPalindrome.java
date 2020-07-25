class Solution {
    public boolean isPalindrome(String s) {
     
    s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
    int beg = 0;
    int end = s.length()-1;
    while(beg<end)
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