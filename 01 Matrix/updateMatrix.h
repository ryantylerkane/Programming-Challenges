class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        
        for(int i=0; i < matrix.size(); i++)
            for(int j=0; j < matrix[i].size();j++)
            {
                if(matrix[i][j] ==1) //Check for nearest zero.
                {
                    bfs(i,j,matrix);
                }
            }
        
        return matrix;
    }
    

    
void bfs(int row, int col, vector<vector<int>>& matrix)
{
        int distance = 0;
        bool found = false;
        queue<pair<int,int>> neighbors;
        neighbors.push(pair(row,col));
        
        while(!found)
        {
            int size = neighbors.size();
            for(int i=0; i< size;i++){
                
                pair<int,int> current = neighbors.front();
                neighbors.pop();
                
                if(current.first+1 < matrix.size())
                {
                    if(current.first+1<matrix.size() && matrix[current.first+1][current.second] ==0) //Check right adjacent element.
                    {
                        found = true;
                        break;
                    }
                    else
                    {
                        neighbors.push(pair<int,int>(current.first+1,current.second));
                    }
                }
                
                if(current.first-1 >=0)
                {
                     if(matrix[current.first-1][current.second] ==0) //Check left adjacent element.
                    {
                        found = true;
                        break;
                    }
                    else
                    {
                        neighbors.push(pair<int,int>(current.first-1,current.second));
                    }
                }
                
                if(current.second+1<matrix[current.first].size())
                {
                    if(matrix[current.first][current.second+1] ==0)
                    {
                        found = true;
                        break;
                    }
                    else
                    {
                        neighbors.push(pair<int,int>(current.first,current.second+1));
                    }
                }
                
                if(current.second-1>=0)
                {
                    if(matrix[current.first][current.second-1] ==0)
                    {
                        found = true;
                        break;
                    }
                    else
                    {
                        neighbors.push(pair<int,int>(current.first,current.second-1));
                    }
                }
            }
            
            distance++;
        }
        
    matrix[row][col] = distance;
    }
    
    
};