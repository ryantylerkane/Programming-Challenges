class Solution {
    public List<String> letterCombinations(String digits) {
        
        HashMap<String, String> nums = new HashMap<>();
        ArrayList<String> ret = new ArrayList<>();
        
        nums.put("2","abc");
        nums.put("3", "def");
        nums.put("4", "ghi");
        nums.put("5", "jkl");
        nums.put("6", "mno");
        nums.put("7", "pqrs");
        nums.put("8", "tuv");
        nums.put("9", "wxyz");
        
        for(int i =0; i < digits.length(); i++)
        {
            ret = processNum(String.valueOf(digits.charAt(i)), ret, nums);
        }
        
        return ret;
        
    }
    
    private ArrayList<String> processNum(String digit, ArrayList<String> combos, HashMap<String,String> nums)
    {
        String letters = nums.get(digit);
        ArrayList<String> newCombos = new ArrayList<String>();
        
        if(combos.isEmpty())
        {
            for(int i=0; i < letters.length();i++)
                newCombos.add(String.valueOf(letters.charAt(i)));
            return newCombos;
        }
        
        for(String s: combos)
        {
            for(int i=0; i < letters.length();i++)
            {
                newCombos.add(s+letters.charAt(i));
            }
        }
        
        return newCombos;
    }
    
}