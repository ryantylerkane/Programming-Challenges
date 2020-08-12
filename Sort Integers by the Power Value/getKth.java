class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    
    public int getKth(int lo, int hi, int k) {
        int size;
        memo.put(1,0);
        memo.put(2,1);
        PriorityQueue<Node> order = new PriorityQueue<>(hi-lo+1, new NodeComp());
        
        for(int i=lo; i <=hi; i++)
        {
            int current = i;
            order.add(new Node(i,findPowerValue(current)));
        }
        
        for(int i=1; i <k;i++)
        {
            order.poll();
        }
        
        return order.peek().n;
    }
    
    private int findPowerValue(int num)
    {
        int count = 0;
        int curr = num;
        while(!memo.containsKey(curr))
        {
            if(curr%2==0)
                curr /=2;
            else
                curr = curr*3+1;
            count++;
        }
        
        int val = memo.get(curr) + count;
        memo.put(num,val);
        return val;
            
    }
}

class Node{
    public int n;
    public int s;
    
    public Node(int num, int steps)
    {
        n = num;
        s = steps;
    }
    
    public Node()
    {
        n=0;
        s=0;
    }
}

class NodeComp implements Comparator<Node>{ 
              
            // Overriding compare()method of Comparator  
                        // for ascending order of steps
            public int compare(Node n1, Node n2) { 
                if (n1.s < n2.s) 
                    return -1; 
                else if (n1.s > n2.s) 
                    return 1; 
                else if(n1.s==n2.s)
                {
                    if(n1.n < n2.n)
                        return -1;
                    else
                        return 1;
                }
                                return 0; 
                } 
} 