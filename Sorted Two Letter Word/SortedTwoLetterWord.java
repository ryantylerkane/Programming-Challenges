public static void main(String[] args) {
        String test = "AABBB";
        
        int numBs = 0;
        int numDeletions = 0;
        
        for(int i=0; i < test.length(); ++i)
        {
            if(test.charAt(i) == 'B')
                numBs++;
            else
                numDeletions = Math.min(numDeletions+1, numBs); //
        }
        
        System.out.println(numDeletions);
    }