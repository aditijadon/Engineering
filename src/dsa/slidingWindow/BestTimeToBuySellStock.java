package dsa.slidingWindow;

public class BestTimeToBuySellStock {

    static int maxProfitSlidingWindow(int[] prices){
        if (prices == null || prices.length < 2) return 0;
        int left = 0;
        int maxProfit = 0;
        for (int right = 1; right < prices.length; right++) {
           if (prices[right] < prices[left]) {
                left = right;
           } else {
               int currentProfit = prices[right] - prices[left];
               maxProfit = Math.max(maxProfit, currentProfit);
           }
        }
        return maxProfit;
    }

    static int maxProfit(int[] prices){
        if (prices == null || prices.length < 2) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {10,1,7,5,2};
        System.out.println(maxProfit(prices)); // Time O(n) Space O(1)
    }
}
