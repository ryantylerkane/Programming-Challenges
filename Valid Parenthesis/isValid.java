class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack<>();
        char current;
        for(int i=0; i < s.length(); i++)
        {
            current = s.charAt(i);
            if(current == '[' || current =='{' || current =='(') //Open characters.
            {
                stk.push(current);
            }
            else if(stk.empty())
                return false;
            else if(current == ']')
            {
                if(stk.peek() != '[')
                    return false;
                else
                    stk.pop();
            }
            else if(current == ')')
            {
                if(stk.peek() != '(')
                    return false;
                else
                    stk.pop();
            }
             else if(current == '}')
            {
                if(stk.peek() != '{')
                    return false;
                else
                    stk.pop();
            }
        }
        
        if(!stk.empty())
            return false;
        
        return true;
    }
}