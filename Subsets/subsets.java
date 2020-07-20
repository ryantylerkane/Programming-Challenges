class Solution {

     ArrayList<Integer> subset = new ArrayList<Integer>();
     List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {
        buildPowerSet(nums,0);
        return powerSet;
    }
    
    private void buildPowerSet(int nums[], int n)
    {
            powerSet.add(new ArrayList<>(subset));
      
        for(int i=n; i < nums.length;i++)
        {
            subset.add(nums[i]);
            buildPowerSet(nums,i+1);
            subset.remove(subset.size()-1);
        }
            
    }
}