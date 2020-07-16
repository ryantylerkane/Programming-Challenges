class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length==0 || nums2.length==0)
        {
            int empty[]={};
            return empty;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
       HashMap<Integer,Integer> firstNum = new HashMap<>();
        
        for(int n: nums1)
        {
            if(firstNum.containsKey(n))
                firstNum.replace(n, firstNum.get(n)+1);
            else
                firstNum.put(n, 1);
        }
        
        for(int n2: nums2)
        {
            if(firstNum.containsKey(n2) && firstNum.get(n2) > 0)
            {
                ans.add(n2);
                firstNum.replace(n2, firstNum.get(n2)-1);
            }
                
        }
        
        int output[] = new int[ans.size()];
        
        for(int i=0; i< ans.size();i++)
            output[i] = ans.get(i);
        
        return output;
   