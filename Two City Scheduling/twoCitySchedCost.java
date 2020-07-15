class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int savings[] = new int[costs.length]; //Will hold the savings of traveling to city a instead of city b. 
        int n = costs.length/2-1;
        int minCost = 0;
        
        for(int i=0; i < costs.length;i++)
        {
            savings[i] = costs[i][1] - costs[i][0]; 
            minCost+=costs[i][0]; //Add all of the costs of city A to minCost.
        }
        
        Arrays.sort(savings); //The first n elements will give us those traveling to b, second n elements traveling to a.
        
        for(int i=0; i <=n; i++) //Remove instances where the cost to city b would be cheaper.
            minCost += savings[i];
        
        return minCost;
    }
}