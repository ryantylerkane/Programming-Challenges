class Solution {
    public void rotate(int[] nums, int k) {
        
        if(nums.length>1)
            for(int i=0; i <k;i++)
                rotateOnce(nums);
    }
    
    private void rotateOnce(int nums[])
    {
        int last = nums[nums.length-1];
        int temp = 0;
        for(int i=0; i < nums.length;i++)
        {   temp = nums[i];
            nums[i] = last;
            last=temp;
        }
    }
}