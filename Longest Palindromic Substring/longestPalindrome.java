class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0)
            return "";
        else if(s.length()==1)
            return s;
        else //Two or greater characters.
        {
            int evenLength = 0;
            int oddLength = 0;
            int longest = 0; 
            int current = 0;
            int middle = 0;
            for(int i=0; i < s.length(); i++)
            {
                evenLength = checkPalindrome(s, i,i);
                oddLength = checkPalindrome(s, i, i+1);
                current= Math.max(evenLength, oddLength);
                
                if(current>longest)
                {
                    middle = i;
                    longest = current;
                }
            }
            
            int beginning = middle-(longest-1)/2;
            int end = middle + longest/2+1; //Add one to the end index for substring method.
            return s.substring(beginning, end);
        }
        
    }
    
    public int checkPalindrome(String str, int beg, int end) //Returns the length of the longest palindrome that is found within the provided boundaries.
    {
        while(end < str.length() && beg>=0 && str.charAt(beg)==str.charAt(end))//While we are in bounds of string and the characters on each side are equal.
        {
            beg--;
            end++;
        }
        
        return end-beg-1; //Return length.
    }
}