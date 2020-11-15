class Solution {
    public boolean isAnagram(String s, String t) {

        //1��������⣺���� �Ƚ��ַ����Ƿ����
        //ʱ�临�Ӷȣ�O(nlogn)������ n �� s �ĳ��ȣ�����ɱ�O(nlogn) �ͱȽ������ַ����ĳɱ�O(n)��
        //����ʱ��ռ������λ������ʱ�临�Ӷ�ΪO(nlogn)
        // if(s.length() != t.length()) {
        //     return false;
        // }
        // char[] sChar = s.toCharArray();
        // char[] tChar = t.toCharArray();
        // Arrays.sort(sChar);
        // Arrays.sort(tChar);
        // return Arrays.equals(sChar, tChar);

        //2����ϣ��---ͳ����ĸ���ֵ�Ƶ��
        //����26����ĸASCII/Unicode/UTF-8�ȱ����Ӧ��ʮ�����������������飬���ڴ洢��ĸ��++  Сдa-z��ĸASCII/Unicode/UTF-8��Ӧʮ����97-122 
        //�ַ�תint  ���ַ�����õ�int  'c'-'a' = 99-97=2  ��'a'-0=97
        // 2.1 ����26 λ���������ü���������� s ��ĸ��Ƶ�ʣ���t���ټ��������е�ÿ����ĸ�ļ�������Ȼ����������Ƿ�ص���
        //ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
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

        // 2.2 �ü��������ȼ���s��ĸ��Ƶ�ʣ�Ȼ����t������ĸ��Ƶ�ʣ�������С��0�������˵��t�а�������s�е���ĸ
        //ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
        // if(s.length() != t.length()){
        //     return false;
        // }
        // int[] table = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     table[s.charAt(i)]++;
        // }
        // for (int i = 0; i < t.length(); i++) {
        //     table[t.charAt(i) - 'a']--;
        //     if(table[t.charAt(i) - 'a'] < 0) { //t�а���s�в����ڵ���ĸ
        //         return false;
        //     }
        // }
        // return true;

        //2.3 ֱ������128���ȵ�����
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