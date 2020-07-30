class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        if(newColor!=image[sr][sc])
            fill(sr, sc, newColor, image[sr][sc],image);
        
        return image;
    }
    

private:
    void fill(int row, int col, int newColor, int originalColor,vector<vector<int>>& image)
    {
        if(image[row][col] == originalColor)
        {
            image[row][col] = newColor;
            
            if(row+1 < image.size())
                fill(row+1, col, newColor, originalColor, image);
            if(row-1 >=0)
                fill(row-1, col, newColor, originalColor, image);
            if(col+1 < image[row].size())
                fill(row, col+1, newColor, originalColor,image);
            if(col-1 >= 0)
                fill(row, col-1, newColor, originalColor, image);
        }
            
    }
};