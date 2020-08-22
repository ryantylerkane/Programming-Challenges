class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>((n1,n2)-> n2-n1);
        
        for(int stone: stones)
            heap.add(stone);
        
        int stone1, stone2;
        while(heap.size() >1)
        {
            stone1 = heap.poll();
            stone2 = heap.poll();
            if(stone1>stone2)
                heap.add(stone1-stone2);
            else if(stone2>stone1)
                heap.add(stone2-stone1);
            //Otherwise, both stones are destroyed.
        }
        
        if(heap.size()==1)
            return heap.poll();
        else
            return 0;
    }
}