class Solution {
    
    int memo[];
    public boolean canJump(int[] nums) {
        
        memo = new int[nums.length];
        if(checkJumps(nums,0)==1)
        {
            return true;
        }
        
        return false;
    }
    
    private int checkJumps(int nums[], int pos)
    {
        
        if(memo[pos]!=1 && memo[pos] !=2) //Reached the end of the array.
        {
            if(pos==nums.length-1)
                memo[pos] = 1;
            else
            {
                for(int i=1; i <= nums[pos];i++)
                {
                    if(pos+i >= nums.length)
                    {
                        memo[pos]=2;
                        break;
                    }
                    if(checkJumps(nums, pos+i)==1)
                    {
                        memo[pos] = 1;
                        break;
                    }
                }

                memo[pos] = (memo[pos]==0) ? 2 : memo[pos];
            }
        }
        
        return memo[pos];
    }
}
