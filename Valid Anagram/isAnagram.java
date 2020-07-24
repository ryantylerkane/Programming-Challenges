class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        int letters[] = new int[26];
        
        for(int i=0; i < s.length(); i++)
            letters[s.charAt(i)-'a']++;
        
        
        int currentLetter;
        for(int j=0; j < t.length();j++)
        {
            currentLetter = t.charAt(j)-'a';
            if(letters[currentLetter]==0)
                return false;
            else
                letters[currentLetter]--;
        }
        
        return true;
            
    }
}