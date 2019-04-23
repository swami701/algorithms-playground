public class Knapsack01 {
    public static void main(String[] args) {
        char[] items = {'A', 'B', 'C', 'D'};
        int[] weights = {2, 4, 3, 1};
        int[] profits = {40, 20, 30, 10};
        int knapsackCapacity = 6;
        System.out.println("Input Items");
        for (char item : items) {
            System.out.print("\t" + item);
        }
        System.out.println();

        System.out.println("Input Weights");
        for (int item : weights) {
            System.out.print("\t" + item);
        }
        System.out.println();

        System.out.println("Input Profits");
        for (int item : profits) {
            System.out.print("\t" + item);
        }
        System.out.println();
        System.out.println("Knapsack Capacity: " + knapsackCapacity);
        int maxProfits = getMaxProfits(items, weights, profits, knapsackCapacity, 0, 0);
        System.out.println("Max Profits: " + maxProfits);

        int maxProfitsDP = getMaxProfitsByDP(items, weights, profits, knapsackCapacity);
        System.out.println("DP Max Profits: " + maxProfitsDP);
    }

    private static int getMaxProfits(char[] items, int[] weights, int[] profits, int availableCapacity, int currentItemIdx, int profit) {
        if (currentItemIdx >= items.length) return profit;
        int excluding = getMaxProfits(items, weights, profits, availableCapacity, currentItemIdx + 1, profit);
        if (weights[currentItemIdx] > availableCapacity) return excluding;
        int including = getMaxProfits(items, weights, profits, availableCapacity - weights[currentItemIdx], currentItemIdx + 1, profit + profits[currentItemIdx]);
        return Math.max(excluding, including);
    }

    private static int getMaxProfitsByDP(char[] items, int[] weights, int[] profits, int knapSackCapacity) {
        if (items.length < 1) return 0;
        int[][] dict = new int[items.length][knapSackCapacity + 1];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < dict[i].length; j++) {
                if (j == 0) dict[i][j] = 0;
                if (i == 0) {
                    dict[i][j] = (weights[i] <= j) ? profits[i] : 0;
                } else {
                    int withoutCurrent = dict[i - 1][j];
                    if (weights[i] > j) {
                        dict[i][j] = withoutCurrent;
                    } else {
                        int withCurrent = profits[i] + dict[i][j - weights[i]];
                        dict[i][j] = Math.max(withoutCurrent, withCurrent);
                    }
                }
            }
        }
        return dict[dict.length - 1][dict[0].length - 1];
    }
}
