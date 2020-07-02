class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<String>();
        
        for(String word : words)
        {
            if(word.length() ==pattern.length()) //Only process a word if it is the same length as the pattern. 
            {
                if(isPerm(word, pattern))
                    answer.add(word);
            }
        }
        
        return answer;
    }
    
    
    public boolean isPerm(String word, String pattern)
    {
        HashMap<Character, Character> map = new HashMap<>();
        
        for(int i=0; i < word.length();i++)
        {
            //Catches case where the same word character would be forced to map to different pattern characters.
            if(map.containsKey(word.charAt(i)) && (map.get(word.charAt(i)) != pattern.charAt(i))) 
            {
                    return false;
                
            }
            else if(!map.containsKey(word.charAt(i)) && map.containsValue(pattern.charAt(i))) //Catches case where a pattern character has to be mapped to twice.
            {
                return false;
            }
            else
            {
                map.put(word.charAt(i), pattern.charAt(i));
            }
        }
        
        return true;
    }
}