class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1�������������
        //ʱ�临�Ӷ�O(NKlogK) NΪ���鳤�� KΪstrs���ַ�������󳤶�
        //�ռ临�Ӷ�O(NK)  ???
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

        //���������ࡾִ��ʱ��ȵ�һ����  ��һ��7~8ms���ڶ���25~26ms��
        //˼·����ĸ���ֵ�Ƶ����ͬ����Ϊ��λ��  #1#2#0#....
        //ʱ�临�Ӷ�O(NK)  �ռ临�Ӷ�O(NK)
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