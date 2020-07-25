class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder();
        
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        
        for(int i=0; i < strs[0].length();i++)
        {
            for(int j=0; j < strs.length; j++)
            {
                if(i>=strs[j].length() || strs[j].charAt(i)!=strs[0].charAt(i))
                {
                    return answer.toString();
                }
            }
            
            answer.append(strs[0].charAt(i));
        }
        
        return answer.toString();
    }
}