class Solution {
    public int countPrimes(int n) {
        
        if(n<3)
            return 0;
        else
        { 
            boolean isComposite[] = new boolean[n+1];
            int answer = n;
            for(int i=2; i <= n/2; i++)
            {
                if(!isComposite[i])
                {
                    for(int j = i+i; j < n;j+=i)
                    {
                        if(!isComposite[j])
                        {
                            isComposite[j]=true;
                            answer--;
                        }
                    }
                }
            }


        return answer-2; //Return -2 to account for zero and 1, which are composite numbers.
        }
       
    }
    
}