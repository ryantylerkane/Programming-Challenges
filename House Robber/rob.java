class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==0)
            return 0;
        else if(nums.length==1)
            return nums[0];
        else if(nums.length==2)
            return Math.max(nums[0], nums[1]);
        else //At least three houses.
        {
            int memo[] = new int[nums.length];
            Arrays.fill(memo,-1);
            
            return Math.max(houses(0, memo,nums), houses(1, memo, nums));
            
        }
        
    }
    
    public int houses(int currentHouse, int memo[], int nums[])
    {
        if(currentHouse >= nums.length)
        {
            return 0; //Base Case
        }
        
        if(memo[currentHouse] != -1) //Check if current value was encountered.
        {
            return memo[currentHouse];
        }
        
        int answer;
       answer= Math.max(nums[currentHouse] + houses(currentHouse+2, memo, nums), nums[currentHouse]+ houses(currentHouse+3, memo, nums)); 
        memo[currentHouse] = answer;
        return answer;
    }
}