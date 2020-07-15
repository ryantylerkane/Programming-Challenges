class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length==0)
            return 0;
        
        int listBeg =0;
        
        for(int i=1; i < nums.length;i++)
        {
            if(nums[i] != nums[listBeg])
            {
                nums[++listBeg] = nums[i];
            }
                
        }
        
        return listBeg+1;
    }
}