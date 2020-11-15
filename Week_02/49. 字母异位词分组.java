class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1、排序数组分类
        //时间复杂度O(NKlogK) N为数组长度 K为strs中字符串的最大长度
        //空间复杂度O(NK)  ???
        // Map<String, List> result = new HashMap<String, List>();
        // for(int i=0; i<strs.length; i++){
        //     char[] sChar = strs[i].toCharArray();
        //     Arrays.sort(sChar);
        //     String key = String.valueOf(sChar);
        //     if (!result.containsKey(key)) {
        //         result.put(key, new ArrayList());
        //     }
        //     result.get(key).add(strs[i]);
        // }
        // return new ArrayList(result.values());

        //按计数分类【执行时间比第一种慢  第一种7~8ms，第二种25~26ms】
        //思路：字母出现的频率相同，则为异位词  #1#2#0#....
        //时间复杂度O(NK)  空间复杂度O(NK)
        Map<String, List> result = new HashMap<String, List>();
        for(String s : strs){
            int[] count = new int[26];
            Arrays.fill(count, 0);
            char[] sChar = s.toCharArray();
            for (char c : sChar) count[c - 'a']++;
            StringBuffer sb = new StringBuffer();
            for(int num : count){
                sb.append("#").append(num);
            }
            String key = sb.toString();
            if(!result.containsKey(key)){
                result.put(key,new ArrayList());
            }
            result.get(key).add(s);
        }
        return new ArrayList(result.values());
    }
}