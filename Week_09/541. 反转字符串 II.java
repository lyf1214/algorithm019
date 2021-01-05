class Solution {
    public String reverseStr(String s, int k) {
        //1、暴力法
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i += 2*k) {
            int start = i, end = Math.min(i + k - 1 , charArray.length-1);
            //反转2k中的前k个字符,不足k个元素的也全部反转(i与j字符交换)
            while (start < end) {
                char temp = charArray[start];
                charArray[start++] = charArray[end];
                charArray[end--] = temp;
            }
        }
        return String.valueOf(charArray);
    }
}