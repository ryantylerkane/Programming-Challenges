class Solution {
    public void moveZeroes(int[] nums) {
        int nzInd = 0;
        
        for(int i=0; i< nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[nzInd] = nums[i];
                nzInd++;
            }
        }
        
        for(int i=nzInd; i < nums.length;i++)
        {
            nums[i] = 0;
        }
    }
}