/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        int beg = 1;
        int mid = beg + (n-beg)/2;
        int guess = guess(mid);
        
        while(guess!=0)
        {
            if(guess== -1)
            {
                n = mid-1;   
            }
            else
            {
               beg = mid+1; 
            }
            
            mid = beg + (n-beg)/2;
            guess = guess(mid);
        }
        
        return mid;
    }
}