class Solution {
     /**
        n = 0  f(0) = 0
        n = 1  f(1) = 1
        n = 2  f(2) = 2
        n = 3  f(3) = f(1) + f(2) = 3
        n = 4  f(4) = f(3) + f(2) = 5
    */
    //1����̬�滮
    //ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
    //˼·����f(n)=f(n-1)+f(n-2),��ǰ̨����ǰһ��̨��sub1��ǰ����̨��sub2�йأ��̱���̨��n,��ÿ��ֻ��������sub1��sub2����
    // public int climbStairs(int n) {
    //     int sub1 = 1, sub2 = 0, result = 0;
    //     for ( int i = 1; i <= n; i++) {
    //         result = sub1 + sub2;
    //         sub2 = sub1;
    //         sub1 = result;
    //     }
    //     return result;
    // }

    //��̬�滮��һ��д�� ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n)
    // public int climbStairs(int n) {
    //     int[] dp = new int[n+1];
    //     dp[0] = 1;
    //     dp[1] = 1;
    //     for(int i = 2; i <= n; i++) {
    //         dp[i] = dp[i-1] + dp[i-2];
    //     }
    //     return dp[n];
    // }

    //2��ͨ�ʽ����ѧ�� ʱ�临�Ӷ�O(logn)
    // public int climbStairs(int n) {
    //     double sqrt_5 = Math.sqrt(5);
    //     double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
    //     return (int)(fib_n / sqrt_5);
    // }
}