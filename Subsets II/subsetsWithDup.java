class Solution {
    
    ArrayList<List<Integer>> powerSet = new ArrayList<>();
      ArrayList<Integer> subset = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        generatePowerset(nums,0,subset);
        return powerSet;
        
    }
    
    private void generatePowerset(int nums[], int start)
    {
        
        powerSet.add(new ArrayList<>(subset));
        
        for(int i=start; i < nums.length;i++)
        {
            if(i> start && nums[i-1] == nums[i])
            {
                continue; //Ignore duplicates in sorted array.
            }
            
            subset.add(nums[i]); //Add current number to the subset.
            generatePowerset(nums, i+1);
            subset.remove(subset.size()-1);
        }
    }
}