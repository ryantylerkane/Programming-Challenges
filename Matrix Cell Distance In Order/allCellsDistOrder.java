class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        
        ArrayList<ArrayList<int[]>> distances = new ArrayList<>();
        
        for(int i =0; i< R+C; i++)
        {
            distances.add(new ArrayList<int[]>()); //Create arrays to store r,c pairs.
        }
        
        for(int i=0; i < R; i++)
        {
            for(int j=0; j < C; j++)
            {
                int mDistance = Math.abs(r0-i) + Math.abs(c0-j); //Calculate Manhattan distance.
                int pair[] = new int[2];
                pair[0] = i;
                pair[1] = j;
                distances.get(mDistance).add(pair); //Add the pair array to its distance represented in the Array.   
            }
        }
        
        int[][] ans = new int[R*C][2]; //Instantiate return arrays.
        
        int currentIndex = 0;
        for(ArrayList<int[]> dist : distances)
        {
            for(int[] pair : dist)
                ans[currentIndex++] = pair;
        }
        
        return ans;
        
    }
}