class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck.length==0 || deck.length==1)
            return deck;
        
        int ans[] = new int[deck.length];
        boolean isFilled[] = new boolean[deck.length];
        Arrays.sort(deck);
        int d = 0;
        int a = 0;
        int totalFilled = 0;
        boolean fill = true;
        
        while(totalFilled < ans.length)
        {
            if(!isFilled[a])
            {
                if(fill)
                {
                    ans[a] = deck[d];
                    d++;
                    isFilled[a] = true;
                    fill = false;
                    totalFilled++;
                }
                else
                    fill = true;
            }
            a = (a + 1) % (isFilled.length);
        }
        
        return ans;
    }
}