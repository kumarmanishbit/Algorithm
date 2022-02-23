package com.mani.soni.dynamicprogramming;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] value = {10, 40, 30, 50};

        int[] weight = {5, 4, 6, 3};

        int knapsack = 10;

        System.out.println(findMaxValue(knapsack, value, weight, 0));
        System.out.println(findMaxValueMemoization(value, weight, knapsack));
        System.out.println(findMaxValueTabulation(value, weight, knapsack));

    }

    /**
     * Recursive solution for this problem.
     * TC: O(2n) This is exponential
     * <p>
     * SC: The space complexity is O(n)O(n). This space will be used to store the recursion stack.
     * Since our recursive algorithm works in a depth-first fashion, which means, we can’t
     * have more than ‘n’ recursive calls on the call stack at any time.
     *
     * @param knapsack
     * @param value
     * @param weight
     * @param index
     * @return
     */
    private static int findMaxValue(int knapsack, int[] value, int[] weight, int index) {

        // base checks
        if (knapsack <= 0 || index >= value.length) {
            return 0;
        }

        int profit1 = 0;
        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        // This is important to check if we can include this item or not.
        if (knapsack >= weight[index]) {
            profit1 = value[index] + findMaxValue(knapsack - weight[index], value, weight, index + 1);
        }

        // recursive call after excluding the element at the currentIndex
        return Math.max(profit1,
                findMaxValue(knapsack, value, weight, index + 1));
    }

    /**
     * Top-down Dynamic Programming with Memoization
     * We can use memoization to overcome the overlapping sub-problems.
     * To reiterate, memoization is when we store the results of all the
     * previously solved sub-problems and return the results from memory
     * if we encounter a problem that has already been solved.
     * <p>
     * <p>
     * Time and Space Complexity:
     * What is the time and space complexity of the above solution? Since our memoization array dp[profits.length][capacity+1]
     * stores the results for all the subproblems, we can conclude that we will not have more than N*CN∗C subproblems
     * (where ‘N’ is the number of items and ‘C’ is the knapsack capacity). This means that our time complexity will be O(N*C)O(N∗C).
     * <p>
     * The above algorithm will be using O(N*C)O(N∗C) space for the memoization array. Other than that, we will use O(N)O(N)
     * space for the recursion call-stack. So the total space complexity will be O(N*C + N)O(N∗C+N), which is asymptotically
     * equivalent to O(N*C)O(N*C).
     *
     * @param value
     * @param weight
     * @param knapsack
     * @return
     */
    private static int findMaxValueMemoization(int[] value, int[] weight, int knapsack) {
        /**
         *  Since we have two changing values (capacity and currentIndex) in our recursive function findMaxValue(),
         *  we can use a two-dimensional array to store the results of all the solved sub-problems.
         *  As mentioned above, we need to store results for every sub-array (i.e., for every possible index ‘i’)
         *  and for every possible capacity ‘c’.
         */
        Integer[][] dp = new Integer[value.length][knapsack + 1];
        return findMaxValueMemoizationUtil(value, weight, knapsack, dp, 0);
    }

    private static int findMaxValueMemoizationUtil(int[] value, int[] weight, int knapsack, Integer[][] dp, int index) {

        // base checks
        if (knapsack <= 0 || index >= value.length) {
            return 0;
        }

        // if we have already solved a similar problem, return the result from memory
        if (dp[index][knapsack] != null) {
            return dp[index][knapsack];
        }
        int profit1 = 0;

        if (knapsack >= weight[index]) {
            profit1 = value[index] + findMaxValue(knapsack - weight[index], value, weight, index + 1);
        }

        dp[index][knapsack] = Math.max(profit1,
                findMaxValue(knapsack, value, weight, index + 1));

        return dp[index][knapsack];
    }

    /**
     *
     * dp[i][c] = max (dp[i-1][c], profits[i] + dp[i-1][c-weights[i]])
     *
     * TC: O(N * C)
     * SC: O(N * C)
     * @param value
     * @param weight
     * @param knapsack
     * @return
     */
    private static int findMaxValueTabulation(int[] value, int[] weight, int knapsack) {

        // basic checks
        if (knapsack <= 0 || value.length == 0 || weight.length != value.length)
            return 0;

        // dp[i][c] will represent the maximum knapsack profit for capacity ‘c’
        // calculated from the first ‘i’ items
        int dp[][] = new int[value.length+ 1][knapsack + 1];

        System.out.println(dp.length);

        for (int i = 0; i < value.length + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < knapsack + 1; i++) {
            dp[0][i] = 0;
        }

        /**
         *
         * for each item at index ‘i’ (0 <= i < items.length) and capacity ‘c’ (0 <= c <= capacity), we have two options:
         *
         * Exclude the item at index ‘i’. In this case, we will take whatever profit we get from the sub-array excluding
         * this item => dp[i-1][c]
         * Include the item at index ‘i’ if its weight is not more than the capacity. In this case, we include its profit
         * plus whatever profit we get from the remaining capacity and from remaining
         * items => profits[i] + dp[i-1][c-weights[i]]
         *
         * dp[i][c] = max (dp[i-1][c], profits[i] + dp[i-1][c-weights[i]])
         *
         */
        // process all sub-arrays for all the capacities
        for (int i = 1; i < value.length + 1; i++) {
            for (int j = 1; j < knapsack + 1; j++) {
                // build solution sequentially.
                // include the item, if it is not more than the capacity
                if(weight[i - 1] <= j) {
                    dp[i][j] = value[i - 1] + dp[i - 1][j - weight[i - 1]];
                }
                // take maximum
                // exclude the item dp[i - 1][j]
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }

        printSelectedElements(dp, weight, value, knapsack);

        // maximum profit will be at the bottom-right corner.
        return dp[value.length][knapsack];
    }

    private static void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity){
        System.out.print("Selected weights:");
        int totalProfit = dp[weights.length][capacity];

        /**
         * As you remember, at every step, we had two options: include an item or skip it.
         * If we skip an item, then we take the profit from the remaining items (i.e., from the cell right above it);
         * if we include the item, then we jump to the remaining profit to find more items.
         */
        for(int i = weights.length; i > 0; i--) {
            if(totalProfit != dp[i - 1][capacity]) {
                System.out.print(" " + weights[i - 1]);
                capacity -= weights[i - 1];
                totalProfit -= profits[i - 1];
            }
        }

        if(totalProfit != 0)
            System.out.print(" " + weights[0]);
        System.out.println("");
    }

}
