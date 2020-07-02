class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() ==0)
            return 0;
        else if(s.length()==1)
            return 1;
        else
        { 
            HashMap<Character, Integer> charIndex = new HashMap<>(); //Map characters to their position in the string.
            
            int longest = 1;
            int beginning = 0;
            
            for(int i=0; i < s.length(); i++)
            {
                char currentChar = s.charAt(i);
                if(charIndex.containsKey(currentChar))
                {
                    beginning = Math.max(charIndex.get(currentChar), beginning); //Make sure to start from character that is not from a prior sub-string.
                }
                /*Store at i+1 and add +1 to current window to account for cases where the entirety of the string
                contains no repeat characters.*/
                longest = Math.max(i+1-beginning, longest);
                charIndex.put(currentChar,i+1); 
            }
            
            return longest;
        }
    }
}