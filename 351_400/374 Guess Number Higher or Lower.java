/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.
 */

/*
注意不要使用（r+l)/2表示middle value，这样会导致int超出内存，并为l赋值为负值，
从而死循环导致time limit exceeded
 */
public int guessNumber(int n){
    int l = 1;
    int r = n;
    int mid, guess_num = 0;
    while(l < r){
        mid = (r - l) / 2 + l;
        // Do NOT use (r+l)/2 in case of integer over flow
        guess_num = guess(mid);
        if (guess_num == 0)
            return mid;
        else if(guess_num == 1){
            l = mid+1;
        }else{
            r = mid-1;
        }
    }
    return l;
}
