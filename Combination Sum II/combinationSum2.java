class Solution {
    
    ArrayList<List<Integer>> combinations = new ArrayList<>();
    ArrayList<Integer> sub = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); //Sort the candidates so that duplicates can be easily identified.
        getSubs(candidates, 0, target);
        return combinations;
    }
    
    
    private void getSubs(int[] candidates, int pos, int target)
    {
        if(target==0)
        {
            combinations.add(new ArrayList<>(sub));
            return;
        }
        
        if(target<0)
            return; //Break out of this potential solution to try others.
        
        for(int i=pos; i < candidates.length;i++)
        {
            if(i > pos && candidates[i-1]==candidates[i])
                continue;
            else
            {
                sub.add(candidates[i]);
                getSubs(candidates, i+1, target-candidates[i]);
                sub.remove(sub.size()-1);
            }
        }
    }
}