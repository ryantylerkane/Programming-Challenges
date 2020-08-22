class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(k==nums.length)
            return nums;
        
        HashMap<Integer, Integer> values = new HashMap<>();
        Queue<Integer> heap;
        for(int n: nums)
        {
            if(values.containsKey(n))
                values.put(n,values.get(n)+1);
            else //Haven't encountered element yet.
                values.put(n, 1);
        }
        
        int current = 0;
        heap = new PriorityQueue<>(
            (n1, n2) -> values.get(n1) - values.get(n2)); //Lambda function representing a comparator to remove the lower of two elements.
       for(Integer i: values.keySet())
       {
          heap.add(i);
           if(heap.size() > k)
               heap.poll(); //Remove lowest element if we go over k total elements in the heap.
       }
        int answer[] = new int[k];
        while(!heap.isEmpty())
        {
            answer[--k] = heap.poll();
        }
        return answer;
    }
}