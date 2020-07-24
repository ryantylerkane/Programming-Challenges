class Solution {
    public boolean isValidSudoku(char[][] board) {
    
    HashSet<Character> rows = new HashSet<>();
    HashSet<Character> cols = new HashSet<>();
    HashSet<Character> mini = new HashSet<>();
    
        int miniRow=0;
        int miniCol=0;
        
        for(int i=0; i <board.length; i++)
        {
            for(int j=0; j < board.length; j++)
            {
                if(board[i][j]!='.')
                {
                    if(!rows.add(board[i][j]))
                        return false;
                }
                
                if(board[j][i]!='.')
                {
                    if(!cols.add(board[j][i]))
                        return false;
                }
                
                if(board[miniRow+j/3][miniCol+j%3] != '.')
                {
                    if(!mini.add(board[miniRow+(j/3)][miniCol+j%3]))
                        return false;
                }
                
            }
            
            rows.clear();
            cols.clear();
            mini.clear();
            miniCol+=3;
            if((i+1)%3==0)
            {
                miniRow+=3;
                miniCol = 0;
            }
        }
        
        return true;
    }   
}