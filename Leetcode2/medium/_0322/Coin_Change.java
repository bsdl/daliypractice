package medium._0322;

class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) 
            return 0;
        if (coins.length == 1 && coins[0] == amount)
            return 1;
        else if (coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;    
        for (int i = 1; i <= amount; i++) {
            int cost = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    int tmp = dp[i - coins[j]] + 1;
                    if (tmp == Integer.MIN_VALUE)
                        tmp = Integer.MAX_VALUE;
                    cost = Math.min(cost, tmp);
                }
            }
            dp[i] = cost;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1: dp[amount];
    }
}