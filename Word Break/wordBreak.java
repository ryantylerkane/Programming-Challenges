class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(wordDict.size()==0 || s.length()==0)
            return false;
        
        HashSet<String> words = new HashSet<>(wordDict);
        
        boolean memo[] = new boolean[s.length()+1];
        memo[0] = true;
        for(int i=0; i < s.length();i++)
            for(int j=0; j<=i;j++)
            {
                if(words.contains(s.substring(j,i+1)) && (j==0 || memo[j]))
                {
                    memo[i+1] = true;
                }
            }
        
        return memo[s.length()];
    }
}