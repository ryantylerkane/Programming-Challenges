class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s.equals(""))
            return true;
        
        if(t.length() < s.length())
        {
            return false;
        }
        
        int sPos = 0;
        
        
        for(int i=0; i < t.length(); i++)
        {
            if(t.charAt(i) == s.charAt(sPos))
            {
                if(++sPos == s.length())
                    return true;
            }
        }
        
        return false;
    }
}