class Solution {
    public int singleNumber(int[] nums) {
        
     HashMap<Integer,Integer> number = new HashMap<>();
        
    for(int n: nums)
    {
        number.put(n, number.getOrDefault(n, 0)+1);
    }
        
    for(int num:nums)
        if(number.get(num)==1)
            return num;
        
        return -1;
    }
}