class Solution {
    public String reverseStr(String s, int k) {
        //1��������
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i += 2*k) {
            int start = i, end = Math.min(i + k - 1 , charArray.length-1);
            //��ת2k�е�ǰk���ַ�,����k��Ԫ�ص�Ҳȫ����ת(i��j�ַ�����)
            while (start < end) {
                char temp = charArray[start];
                charArray[start++] = charArray[end];
                charArray[end--] = temp;
            }
        }
        return String.valueOf(charArray);
    }
}