class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.equals(""))
            return 0;
        
        int beg = 0;
        int end = needle.length()-1;
        while(end < haystack.length())
        {
            if(haystack.substring(beg, end+1).equals(needle))
            {
                return beg;
            }
            else
            {
                beg++;
                end++;
            }
        }
        
        return -1;
    }
}