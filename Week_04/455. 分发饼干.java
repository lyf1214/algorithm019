class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //̰���㷨
        //˼·���þ���С�ı���ȡ����С����ĺ��ӡ����� + ������
        int count = 0; 
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0;
        while (i < g.length && j < s.length) {
            if (g[i] > s[j]){ //���㲻��С���ӵ�θ�ڣ����ɳߴ����
                j++;
            }else { //����С���ӵ�θ�ڣ����ɳߴ硢С���Ӻ��ƽ����¸�С��θ���ж�
                i++;
                j++;
                count++;
            }
        }
        return count;
    }
}


-- �Ż���
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //̰���㷨
        //˼·���þ���С�ı���ȡ����С����ĺ��ӡ����� + ������
        int count = 0; 
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]){ //����С���ӵ�θ�ڣ�С���Ӻ��ƽ����¸�С��θ���ж�
                i++;
                count++;
            }
            j++;
        }
        return count;
    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //̰���㷨
        //˼·���ô������������θ�ڴ�ģ���ͳ������С������ ������ + ������
        int count = 0; 
        Arrays.sort(g);
        Arrays.sort(s);
        int j = s.length-1;
        for(int i = g.length-1; i >= 0; i--) {
            if (j >= 0 && s[j] >= g[i]) { //����С����θ��
                count++;
                j--;
            }
            
        }
        
        return count;
    }
}