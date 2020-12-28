public class Solution {
    // you need to treat n as an unsigned value
    //1��ѭ�� + λ�ƶ�(˼·��n & mask����  [mask=1])
    //ѭ�������̶�λ32
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

    //2��λ������С���� �� n = n&(n-1)�Ὣn�����λ1��ֵ��Ϊ0������λ���ֲ���
    //ѭ����������n��1������
    // public int hammingWeight(int n) {
    //     int sums = 0;
    //     while (n != 0) {
    //         //System.out.println("n=="+ n);
    //         sums++;
    //         n &= (n-1);
    //     }
    //     return sums;
    // }

    //3���ݹ�(n & (n-1))
    public int hammingWeight(int n) {
        return n == 0 ? 0 : 1 + hammingWeight(n & (n-1));
    }

}