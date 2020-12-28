public class Solution {
    // you need to treat n as an unsigned value
    //1、循环 + 位移动(思路：n & mask掩码  [mask=1])
    //循环次数固定位32
    // public int hammingWeight(int n) {
    //     int bits = 0;
    //     int mask = 1;
    //     for (int i = 0; i < 32; i++) {
    //         if ((n & mask) != 0) {
    //             bits++;
    //         }
    //         mask <<= 1;
    //     }
    //     return bits;
    // }

    //2、位操作的小技巧 ： n = n&(n-1)会将n中最低位1的值变为0，其他位保持不变
    //循环次数等于n的1的数量
    // public int hammingWeight(int n) {
    //     int sums = 0;
    //     while (n != 0) {
    //         //System.out.println("n=="+ n);
    //         sums++;
    //         n &= (n-1);
    //     }
    //     return sums;
    // }

    //3、递归(n & (n-1))
    public int hammingWeight(int n) {
        return n == 0 ? 0 : 1 + hammingWeight(n & (n-1));
    }

}