class Solution {
    public String defangIPaddr(String address) {
        
        StringBuilder answer = new StringBuilder();
        
        for(int i =0; i < address.length(); i++)
        {
            if(address.charAt(i) == '.')
            {
                answer.append("[.]");
            }
            else
            {
                answer.append(address.charAt(i));
            }
        }
        
        return answer.toString();
    }
}