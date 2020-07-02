class Solution {
    public int minSteps(String s, String t) {
        
        
        if(s.equals(t)) //Check for case when the input values are equal.
            return 0;
        
        int minSteps = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        
        
        for(int i = 0; i < s.length(); i++)
        {
            if(!sMap.containsKey(s.charAt(i)))
                sMap.put(s.charAt(i),1);
            else
                 sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);
        }
        
        for(int i=0; i < t.length(); i++)
        {
            if(!sMap.containsKey(t.charAt(i)) || sMap.get(t.charAt(i)) <= 0)
                minSteps++;
            else if(sMap.get(t.charAt(i)) > 0)
                sMap.put(t.charAt(i), sMap.get(t.charAt(i))-1);
        }
        
        return minSteps;
    }
}