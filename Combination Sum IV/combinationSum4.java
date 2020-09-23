class Solution {
    int memo[];
    public int combinationSum4(int[] nums, int target) {
        if(nums.length==0)
            return 0;
        memo = new int[target+1];
        int ans = findCombinations(nums, target);
        if(ans==-1)
            return 0;
        else
            return ans;
    }
    
    private int findCombinations(int nums[], int target)
    {
         if(target < 0 || memo[target]==-1)
            return 0;
        if(target==0)
            return 1;
        if(memo[target] ==0)
        {
            int totalComb=-1;
            int curr = 0;
            for(int n:nums)
            {
                curr = findCombinations(nums, target-n);
                if(curr >0)
                    totalComb+=curr;
            }
            memo[target] = (totalComb<0) ? -1 : totalComb+1;
            
        }
        return memo[target];
    }
}