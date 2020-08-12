class Solution {
    public int findJudge(int N, int[][] trust) {    
        
        int trusted[] = new int[N+1];
        int trusts[] = new int[N+1];
        
        for(int per[] : trust)
        {
            trusts[per[0]]++;
            trusted[per[1]]++;
        }
        
        for(int i=1; i <=N;i++)
            if(trusts[i] ==0 && trusted[i]==N-1)
                return i;
        
        return -1;
        
    }
}