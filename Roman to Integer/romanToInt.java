class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>();
        
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        
        int total=0;
        int walk =0;
        int run = 1;
        char current;
        char prev;
       while(run < s.length())
        {
            current = s.charAt(run);
            prev = s.charAt(walk); 
            
            if(roman.get(current) > roman.get(prev))
            {
               total+=roman.get(current)-roman.get(prev);
                run+=2;
                walk+=2;
            }
            else
            {
                total+=roman.get(prev);
                 run++;
                walk++;
           
            }
        }
        
        if(walk < s.length()) //Will evaluate to true if the last two characters aren't part of the same operand.
        {
            total+=roman.get(s.charAt(walk));
        }
        
        return total;
    }
}