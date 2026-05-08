class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxGain = 0;

        for (int price : prices) {
            buyPrice = Math.min(buyPrice, price);
            maxGain = Math.max(maxGain, price - buyPrice);
        }

        return maxGain;
    }
}
