class Solution {
    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    List<Integer> subset = new ArrayList<Integer>();
    int limit;
    public List<List<Integer>> combine(int n, int k) {
        limit = k;
        getCombinations(1,n);
        return answer;
    }
    
    private void getCombinations(int start, int end)
    {
        if(subset.size()==limit)
        {
            answer.add(new ArrayList<Integer>(subset));
            return;
        }
        
        for(int i=start; i <= end-(limit-subset.size())+1; i++)
        {
            subset.add(i);
            getCombinations(i+1, end);
            subset.remove(subset.size()-1);
        }
    }
}