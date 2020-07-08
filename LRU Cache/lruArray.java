class LRUCache {

    private HashMap<Integer, Integer> values;
    private ArrayList<Integer> used;
    private int capacity;
    public LRUCache(int capacity) {
        
        values = new HashMap<>();
        used = new ArrayList<Integer>();
        this.capacity = capacity;
        
    }
    
    public int get(int key) {
        
        if(values.containsKey(key))
        {
            updateCache(key);
            return values.get(key);
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(!values.containsKey(key))
        {
             if(values.keySet().size() == capacity)
            {
                values.remove(used.get(0));
                used.remove(0);
            }
            values.put(key, value);
            used.add(key);
        }
        
        else
        {
            values.replace(key, value);
            updateCache(key);
        }
    }
    

    private void updateCache(int key)
    {
        for(int i=0; i < used.size();i++)
        {
            if(used.get(i)==key)
            {
                used.remove(i);
                break;
            }
        }
        
        used.add(key);
    }
}
