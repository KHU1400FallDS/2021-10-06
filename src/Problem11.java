public class Problem11 {
    private static final int[] COINS = new int[]{10, 5, 2};

    public static void main(String[] args) {
        solve(29, 0, new int[]{0, 0, 0});
    }

    private static void solve(int remaining, int currentCoinIndex, int[] coinsCount) {
        if (remaining == 0) {
            coinsCount[2] = 0;
            printSolution(coinsCount);
            return;
        }

        if (COINS[currentCoinIndex] == 2) {
            if (remaining % 2 == 0) {
                coinsCount[2] = remaining / 2;
                printSolution(coinsCount);
            }

            return;
        }

        int maximumCount = remaining / COINS[currentCoinIndex];

        for (int i = maximumCount; i >= 0; i--) {
            coinsCount[currentCoinIndex] = i;
            solve(remaining - i * COINS[currentCoinIndex], currentCoinIndex + 1, coinsCount);
        }
    }

    private static void printSolution(int[] coinsCount) {
        System.out.println(coinsCount[0] + "x10 + " + coinsCount[1] + "x5 + " + coinsCount[2] + "x2");
    }
}
