class Solution {
    public void solve(char[][] board) {
        
        //Check all four sides of the board for O's and any neighboring O's.
        
    if(board.length >0 && board[0].length >0)
        {   for(int i=0; i < board[0].length;i++) //Check top row.
            {
                if(board[0][i] == 'O')
                {
                    board[0][i] = 'P';
                    board = checkNeighbors(board, 0,i);
                }
            }

             for(int i=0; i < board[board.length-1].length;i++) //Check bottom row.
            {
                if(board[board.length-1][i] == 'O') 
                {
                    board[board.length-1][i] = 'P';
                    board = checkNeighbors(board, board.length-1,i);
                }
            }

            for(int i=0; i < board.length;i++)
            {
                if(board[i][0]=='O')
                {
                    board[i][0] = 'P';
                    board = checkNeighbors(board, i, 0);
                }
            }

            for(int i=0; i <board.length; i++)
            {
                if(board[i][board[0].length-1] =='O')
                {
                    board[i][board[0].length-1] = 'P';
                    board = checkNeighbors(board,i,board[0].length-1);
                }
            }

            for(int i=0; i < board.length;i++)
                for(int j=0; j < board[i].length;j++)
                {
                        board[i][j] = board[i][j] =='P' ? 'O' : 'X';
                }
    }
    }
    
    private char[][] checkNeighbors(char[][] board, int i, int j)
    {
        if(j >= 1 && board[i][j-1]=='O')
        {
            board[i][j-1] = 'P';
            board = checkNeighbors(board, i, j-1);
        }
        
        if(j <board[i].length-1 && board[i][j+1]=='O')
        {
            board[i][j+1] = 'P';
            board = checkNeighbors(board, i, j+1);
        }
        
        if(i >=1 && board[i-1][j]=='O')
        {
            board[i-1][j] = 'P';
            board = checkNeighbors(board, i-1, j);
        }
        
        if(i < board.length-1 && board[i+1][j]=='O')
        {
            board[i+1][j] = 'P';
            board = checkNeighbors(board, i+1, j);
        }
        
        return board;
    }
}
