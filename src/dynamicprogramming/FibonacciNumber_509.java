package dynamicprogramming;

// 什么是重叠子问题？
class FibonacciNumber_509 {
    // 暴力递归
    int fib1(int N) {
        if (N == 1 || N == 2) return 1;
        return fib1(N - 1) + fib1(N - 2);
    }

    // 带备忘录的递归解法
    int fib2(int N) {
        // 备忘录全初始化为 0
        int[] memo = new int[N + 1];
        // 进行带备忘录的递归
        return helper(memo, N);
    }

    int helper(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1) return n;
        // 已经计算过，不用再计算
        if (memo[n] != 0) return memo[n];

        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);

        return memo[n];
    }

    // dp 数组的迭代(递推)解法
    int fib3(int N) {
        if (N == 0) return 0;
        int[] dp = new int[N + 1];

        // base case
        dp[0] = 0;
        dp[1] = 1;

        // 状态转移
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    // 缩小DP table的大小，实际上只需要存储之前的两个状态
    int fib4(int N) {
        if (N==0||N==1){
            // base case
            return N;
        }
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1;
        int dp_i_2 = 0;
        for (int i=2; i<=N; i++) {
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }


    public static void main(String[] args) {
        FibonacciNumber_509 fibonacciNumber = new FibonacciNumber_509();
        System.out.println(fibonacciNumber.fib1(4));
        System.out.println(fibonacciNumber.fib2(4));
        System.out.println(fibonacciNumber.fib3(4));
        System.out.println(fibonacciNumber.fib4(4));
    }

}
