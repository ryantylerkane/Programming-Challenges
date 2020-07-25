class Solution {
    
    ArrayList<List<Integer>> combos = new ArrayList<>();
    ArrayList<Integer> sums = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getSums(candidates,0,target);
        return combos;
    }
    
    private void getSums(int[] candidates,int pos, int target)
    {
        if(target==0) //Only push a sum set if it matches the total.
        {
            combos.add(new ArrayList<>(sums));
            return;
        }
        
        if(target<0) //The total of our subset has exceeded the provided target sum.
            return;
        
        for(int i=pos; i < candidates.length;i++)
        {
            sums.add(candidates[i]);
            getSums(candidates, i, target-candidates[i]);
            sums.remove(sums.size()-1);
        }
    }
}