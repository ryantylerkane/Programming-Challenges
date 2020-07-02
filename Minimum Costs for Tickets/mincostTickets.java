class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int dp[] = new int[366];
        ArrayList<Integer> dayList = new ArrayList<>();
        
        //Convert days array to array list for easier searching.
        for(int day: days)
            dayList.add(day);
        
        return processSchedule(1, dayList, costs, dp);
        
    }
    
    public int processSchedule(int currentDay, ArrayList<Integer>dayList, int costs[], int dp[])
    {
        if(currentDay > dayList.get(dayList.size()-1))
            return 0;  //Base case reached once last day on schedule has been processed.
        
        if(dp[currentDay] != 0) //Check if day has already been encountered.
            return dp[currentDay];
        
        //Day has not yet been encountered.
        int answer;
        
        //Recursively calls testing each day and cost scenario.
        if(dayList.contains(currentDay))
        {
            answer = Math.min(processSchedule(currentDay+1, dayList, costs, dp)+ costs[0], processSchedule(currentDay+7, dayList, costs, dp)+ costs[1]);
            answer = Math.min(answer, processSchedule(currentDay+30, dayList, costs, dp) + costs[2]);
        }
        else //Advance one day ahead if we don't need to buy a ticket on this day.
        {
            answer = processSchedule(++currentDay, dayList, costs, dp);
        }
        
        //Save calculated answers for when the day is encountered.
        dp[currentDay] = answer;
        
        return answer;
        
    }
}