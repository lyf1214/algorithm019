class Solution {
    public boolean isAnagram(String s, String t) {

        //1、暴力求解：排序， 比较字符串是否相等
        //时间复杂度：O(nlogn)，假设 n 是 s 的长度，排序成本O(nlogn) 和比较两个字符串的成本O(n)。
        //排序时间占主导地位，总体时间复杂度为O(nlogn)
        // if(s.length() != t.length()) {
        //     return false;
        // }
        // char[] sChar = s.toCharArray();
        // char[] tChar = t.toCharArray();
        // Arrays.sort(sChar);
        // Arrays.sort(tChar);
        // return Arrays.equals(sChar, tChar);

        //2、哈希表---统计字母出现的频率
        //利用26个字母ASCII/Unicode/UTF-8等编码对应的十进制数字来创建数组，用于存储字母并++  小写a-z字母ASCII/Unicode/UTF-8对应十进制97-122 
        //字符转int  ①字符相减得到int  'c'-'a' = 99-97=2  ②'a'-0=97
        // 2.1 创建26 位计数器表，用计数器表计算 s 字母的频率，用t减少计数器表中的每个字母的计数器，然后检查计数器是否回到零
        //时间复杂度O(n) 空间复杂度O(1)
        // if(s.length() != t.length()){
        //     return false;
        // }
        // int[] counter = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     counter[s.charAt(i) - 'a']++;
        //     counter[t.charAt(i) - 'a']--;
        // }

        // for(int i = 0; i < counter.length; i++){
        //     if (counter[i] != 0) {
        //         return false;
        //     }
        // }
        // return true;

        // 2.2 用计数器表先计算s字母的频率，然后用t减少字母的频率，若出现小于0的情况，说明t中包含不在s中的字母
        //时间复杂度O(n) 空间复杂度O(1)
        // if(s.length() != t.length()){
        //     return false;
        // }
        // int[] table = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     table[s.charAt(i)]++;
        // }
        // for (int i = 0; i < t.length(); i++) {
        //     table[t.charAt(i) - 'a']--;
        //     if(table[t.charAt(i) - 'a'] < 0) { //t中包含s中不存在的字母
        //         return false;
        //     }
        // }
        // return true;

        //2.3 直接声明128长度的数组
        if(s.length() != t.length()){
            return false;
        }
        int[] counter = new int[128];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
            counter[t.charAt(i)]--;
        }

        for(int i = 0; i < counter.length; i++){
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
        
    }
}