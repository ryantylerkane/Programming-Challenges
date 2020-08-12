class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length <=0)
            return 0;
        
        int memo[] = new int[nums.length];
        int max = 1;
        memo[0] = 1;
        int currMax;
        for(int i=1; i < nums.length;i++)
        {
            currMax = 0;
            
            for(int j=0; j <i;j++)
            {
               if(nums[j] < nums[i])
                   currMax = (currMax < memo[j]) ? memo[j] : currMax;
            }
            memo[i] = currMax+1;
            max = (memo[i] > max) ? memo[i] : max;
        }
        
        return max;
    }
}