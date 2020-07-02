class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> answer = new ArrayList<List<String>>();
        
        if(strs.length ==0)
        {
            return answer;
        }
        else if(strs.length ==1)
        {
            LinkedList<String> word = new LinkedList<String>();
            word.add(strs[0]);
            answer.add(word);
            
            return answer;
        }
        
        ArrayList<Integer[]> stringLetters = new ArrayList<Integer[]>();
        for(String s: strs)
        {
            Integer letters[] = new Integer[26];
            Arrays.fill(letters,0);
            for(int i =0; i < s.length(); i++)
            {
                letters[s.charAt(i)-'a']+=1;
            }
           
            checkWord(stringLetters, answer, letters, s);
        }
        
        return answer;
        
    }
    
    public void checkWord(ArrayList<Integer[]> stringLetters, ArrayList<List<String>> answer, Integer letters[], String s)
    {
        Boolean found = false;
        
        for(int i=0; i < stringLetters.size(); i++)
        {
            if(Arrays.equals(letters,stringLetters.get(i))) //Matching anagram found.
            {
                answer.get(i).add(s);
                found=true;
                break; //Except loop if a match is found.
            }
        }
            
        if(!found)//New anagram that has yet to be encountered.
        {
                stringLetters.add(letters);
                LinkedList<String> w = new LinkedList<String>();
                w.add(s);
                answer.add(w);
        }
    }
}