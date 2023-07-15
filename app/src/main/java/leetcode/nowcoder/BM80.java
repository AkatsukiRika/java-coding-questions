package leetcode.nowcoder;

/**
 * 牛客网BM80：买卖股票的最好时机（一）
 */
public class BM80 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int curMinValue = prices[0];
        int curMaxValue = prices[0];
        int curMinIndex = 0;
        int curMaxIndex = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < curMinValue) {
                curMinValue = prices[i];
                curMinIndex = i;
            }

            if (prices[i] > curMaxValue) {
                curMaxValue = prices[i];
                curMaxIndex = i;
            }

            if (curMaxIndex <= curMinIndex && prices[i] > curMinValue && i > curMinIndex) {
                curMaxValue = prices[i];
                curMaxIndex = i;
            }

            System.out.printf("minValue=%d, maxValue=%d, minIndex=%d, maxIndex=%d\n", curMinValue, curMaxValue, curMinIndex, curMaxIndex);

            if (curMaxIndex > curMinIndex && curMaxValue - curMinValue > maxProfit) {
                maxProfit = curMaxValue - curMinValue;
            }
        }

        return maxProfit;
    }
}
