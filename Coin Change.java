import java.util.Arrays;
class Solution {
    public int coinChange(int[] coins, int amount) {
    Arrays.sort(coins);
    int count = 0;
    for (int i = coins.length - 1; i >= 0; i--) {
        if (amount >= coins[i]) {
            count += amount / coins[i]; 
            amount %= coins[i];        
        }
    }
    return amount == 0 ? count : -1;
    }
}
