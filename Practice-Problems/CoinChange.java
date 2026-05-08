import java.util.*;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;

        for (int target = 1; target <= amount; target++) {
            for (int coin : coins) {
                if (coin <= target && minCoins[target - coin] != Integer.MAX_VALUE) {
                    minCoins[target] = Math.min(minCoins[target], minCoins[target - coin] + 1);
                }
            }
        }

        return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];
    }
}
