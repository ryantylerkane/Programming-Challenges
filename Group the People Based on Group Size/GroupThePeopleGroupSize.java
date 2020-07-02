 public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
       List<List<Integer>> groups = new ArrayList<List<Integer>>();
        HashMap<Integer, ArrayList<Integer>> sizes = new HashMap<Integer, ArrayList<Integer>>();
        
        
        for(int i =0; i < groupSizes.length; i++)
        {
            if(!sizes.containsKey(groupSizes[i])) //Check if group size was encountered yet.
                sizes.put(groupSizes[i], new ArrayList<Integer>()); //Create new ArrayList if group size was not yet encountered.
            
            sizes.get(groupSizes[i]).add(i);
            
           if(sizes.get(groupSizes[i]).size() == groupSizes[i]) //Check to see if the group limit has been reached.
           {
               groups.add(sizes.get(groupSizes[i]));
               sizes.remove(groupSizes[i]); //Add the group to the output list.
           }
            
        }
        
        return groups; 
    }
}