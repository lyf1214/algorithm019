class Solution {
    public boolean isPowerOfTwo(int n) {
        //位运算
        //1、思路：若n为2的幂次方，则n转为二进制后，仅且只有一个1----> n = n &(n-1)打掉n的最低位1时，若n为2幂次方时n变为0
        //return n <= 0 ? false : (n & (n-1)) == 0;

        //2、思路：若n为2的幂次方，则 n & (-n) = x； 否则n & (-n) != n
        //return n <= 0 ? false : (n & (-n)) == n;
        //return n > 0 && ((n & -n) == n);

        //3、数学 java int最大值2^31-1
        return n>0 && Math.pow(2,31)%n == 0;
    }
}