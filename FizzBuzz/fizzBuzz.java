class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> out = new ArrayList<String>();
        
        for(int i=1; i <=n;i++)
        {
            StringBuilder answer = new StringBuilder();
            if(i%3!=0 && i%5!=0)
                answer.append(i);
            else
            {
                if(i%3==0)
                    answer.append("Fizz");
                if(i%5==0)
                    answer.append("Buzz");
            }
            
            out.add(answer.toString());
        }
        
        return out;
    }
}