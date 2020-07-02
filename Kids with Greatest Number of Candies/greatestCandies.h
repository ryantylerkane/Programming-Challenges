class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        vector<bool> maxCandies;
        
        
        int max = *max_element(candies.begin(), candies.end());
        
        for(int i=0; i < candies.size(); i++)
        {
            if(candies[i] + extraCandies >= max)
            {
                maxCandies.push_back(true);
            }
            else
            {
                maxCandies.push_back(false);
            }
        }
    
        return maxCandies;
    
    }
};