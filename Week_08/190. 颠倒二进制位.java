public class Solution {
    // you need treat n as an unsigned value
    //λ����
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
           //��res����1λ������n�����λ����
           //res = (res << 1) | (n & 1);
           res = (res << 1) + (n & 1);
           n >>= 1;
        }
        return res;
    }
}