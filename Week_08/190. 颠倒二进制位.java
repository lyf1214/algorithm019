public class Solution {
    // you need treat n as an unsigned value
    //位运算
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
           //将res左移1位，并将n的最低位补入
           //res = (res << 1) | (n & 1);
           res = (res << 1) + (n & 1);
           n >>= 1;
        }
        return res;
    }
}