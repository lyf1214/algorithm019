class Solution {
    public boolean isPowerOfTwo(int n) {
        //λ����
        //1��˼·����nΪ2���ݴη�����nתΪ�����ƺ󣬽���ֻ��һ��1----> n = n &(n-1)���n�����λ1ʱ����nΪ2�ݴη�ʱn��Ϊ0
        //return n <= 0 ? false : (n & (n-1)) == 0;

        //2��˼·����nΪ2���ݴη����� n & (-n) = x�� ����n & (-n) != n
        //return n <= 0 ? false : (n & (-n)) == n;
        //return n > 0 && ((n & -n) == n);

        //3����ѧ java int���ֵ2^31-1
        return n>0 && Math.pow(2,31)%n == 0;
    }
}