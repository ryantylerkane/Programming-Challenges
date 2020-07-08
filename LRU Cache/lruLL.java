class Node{
        
        Node next;
        Node previous;
        int value;
        int key;
        
        public Node(int val, int k)
        {
            value = val;
            key = k;
            next=null;
            previous = null;
        }
       
       public Node()
       {
           value = -1;
           key = -1;
       }
        
    }

class LRUCache {   
    private HashMap<Integer, Node> values;
    private Node head;
    private Node tail;
    private int capacity;
    
    public LRUCache(int capacity) {
        
        values = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
        
    }
    
    public int get(int key) {
        
        if(values.containsKey(key))
        {
            Node currentVal = values.get(key);
            removeNode(currentVal);
            addNode(currentVal);
            return currentVal.value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        Node temp = new Node(value, key);
        
        if(!values.containsKey(key))
        {
             if(values.keySet().size() == capacity)
            {
                values.remove(tail.previous.key);
                removeNode(tail.previous);
            }
            values.put(key, temp);
            addNode(temp);
        }
        
        else
        {
            removeNode(values.get(key));
            values.replace(key, temp);
            addNode(values.get(key));
        }
    }
    
    private void addNode(Node n)
    {
        n.next = head.next;
        n.next.previous = n;
        n.previous = head;
        head.next = n;
    }
    
    private void removeNode(Node n)
    {
        n.previous.next = n.next;
        n.next.previous = n.previous;
    }
}
