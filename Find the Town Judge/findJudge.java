class Solution {
    public int findJudge(int N, int[][] trust) {        
        
        if(N==1)
            return 1;
        
        HashMap<Integer, List<Integer>> trusts = buildMap(trust);
        int current;
        boolean answer = false;
        
        for(int i=1; i <=N;++i)
        {
            if(trusts.containsKey(i))
                continue;
            else
            {
                for(int j=1; j <=N; j++)
                {
                    if(i!=j)
                        if(!trusts.containsKey(j) || !trusts.get(j).contains(i))
                        {
                            answer = false;
                            break;
                        }
                    else
                        answer = true;
                }
            }
            
            if(answer)
                return i;
        }
        
        return -1;
    }
    
    private HashMap<Integer,List<Integer>> buildMap(int trust[][])
    {
        HashMap<Integer, List<Integer>> per = new HashMap<>();
        for(int people[] : trust)
        {
            if(per.containsKey(people[0]))
            {
                per.get(people[0]).add(people[1]);
            }
            else
            {
                ArrayList<Integer> trusted = new ArrayList<>();
                trusted.add(people[1]);
                per.put(people[0],trusted);
            }
        }
        
        return per;
    }
}