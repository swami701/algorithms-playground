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
    }

    private static int getMaxProfits(char[] items, int[] weights, int[] profits, int availableCapacity, int currentItemIdx, int profit) {
        if (currentItemIdx >= items.length) return profit;
        int excluding = getMaxProfits(items, weights, profits, availableCapacity, currentItemIdx + 1, profit);
        if (weights[currentItemIdx] > availableCapacity) return excluding;
        int including = getMaxProfits(items, weights, profits, availableCapacity - weights[currentItemIdx], currentItemIdx + 1, profit + profits[currentItemIdx]);
        return Math.max(excluding, including);
    }
}
