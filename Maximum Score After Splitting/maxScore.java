class Solution {
    public int maxScore(String s) {
        
    int num1s = countOnes(s);
    return findHighest(s, num1s);  
} 
    
    
    public int countOnes(String s)
    {
        int num1s = 0;
        
        for(int i =0; i < s.length(); i++) //Obtain the number of 1's in the string.
        {
            if(s.charAt(i)=='1')
            {
                num1s++;
            }
        }
        
        return num1s;
    }
    
    public int findHighest(String s, int num1s)
    {
        int highest = 0;
        int current = 0;
        int num0s = 0;
        
        for(int i=0; i < s.length(); i++)
        {
            if(s.charAt(i)=='0' && i != s.length()-1)
            {
                current = num1s + (++num0s);
            }
            else
            {
                current = (--num1s)+num0s;
            }

            if(current>highest)
                highest = current;
        }

        return highest;
    }
    
}