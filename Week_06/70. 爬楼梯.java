class Solution {
     /**
        n = 0  f(0) = 0
        n = 1  f(1) = 1
        n = 2  f(2) = 2
        n = 3  f(3) = f(1) + f(2) = 3
        n = 4  f(4) = f(3) + f(2) = 5
    */
    //1、动态规划
    //时间复杂度O(n) 空间复杂度O(1)
    //思路：因f(n)=f(n-1)+f(n-2),当前台阶与前一个台阶sub1和前两个台阶sub2有关，固遍历台阶n,并每次只滚动保存sub1和sub2即可
    // public int climbStairs(int n) {
    //     int sub1 = 1, sub2 = 0, result = 0;
    //     for ( int i = 1; i <= n; i++) {
    //         result = sub1 + sub2;
    //         sub2 = sub1;
    //         sub1 = result;
    //     }
    //     return result;
    // }

    //动态规划另一种写法 时间复杂度O(n) 空间复杂度O(n)
    // public int climbStairs(int n) {
    //     int[] dp = new int[n+1];
    //     dp[0] = 1;
    //     dp[1] = 1;
    //     for(int i = 2; i <= n; i++) {
    //         dp[i] = dp[i-1] + dp[i-2];
    //     }
    //     return dp[n];
    // }

    //2、通项公式（数学） 时间复杂度O(logn)
    // public int climbStairs(int n) {
    //     double sqrt_5 = Math.sqrt(5);
    //     double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
    //     return (int)(fib_n / sqrt_5);
    // }
}