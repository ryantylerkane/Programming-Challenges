    public List<List<Integer>> threeSum(int[] nums) {
          
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        if(nums.length<3)
        {
            return answer;
        }
    
        Arrays.sort(nums); //Sort the input array.
       int current = 0;
        
        while(current != nums.length-1 && nums[current]<=0)
        {
            if(current>=1 && nums[current] == nums[current-1]) 
            {
                current++;
                continue;
            }
            else
            {
                int beg = current+1;
                int end = nums.length-1;
                
                while(beg<end)
                { 
                    if(nums[beg] + nums[end] + nums[current] ==0)
                    {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[current]);
                        temp.add(nums[beg]);
                        temp.add(nums[end]);
                        answer.add(temp);
                        
                        while(beg < end && nums[beg] == nums[beg+1])
                            beg++;
                        while(beg < end && nums[end]==nums[end-1])
                            end--;
                        
                        beg++;
                        end--;
                    }
                    else if(nums[beg] + nums[end] > 0-nums[current])
                        end--;
                    else 
                        beg++;
                    }
               
            }
            
            current++;
        }
        
        return answer;
        
    }
}