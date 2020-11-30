class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //贪心算法
        //思路：用尽量小的饼干取满足小需求的孩子【排序 + 遍历】
        int count = 0; 
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0;
        while (i < g.length && j < s.length) {
            if (g[i] > s[j]){ //满足不了小孩子的胃口，饼干尺寸后移
                j++;
            }else { //满足小孩子的胃口，饼干尺寸、小孩子后移进入下个小孩胃口判断
                i++;
                j++;
                count++;
            }
        }
        return count;
    }
}


-- 优化后
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //贪心算法
        //思路：用尽量小的饼干取满足小需求的孩子【排序 + 遍历】
        int count = 0; 
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]){ //满足小孩子的胃口，小孩子后移进入下个小孩胃口判断
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
        //贪心算法
        //思路：用大饼干优先满足胃口大的，并统计满足小孩数量 【排序 + 遍历】
        int count = 0; 
        Arrays.sort(g);
        Arrays.sort(s);
        int j = s.length-1;
        for(int i = g.length-1; i >= 0; i--) {
            if (j >= 0 && s[j] >= g[i]) { //满足小孩的胃口
                count++;
                j--;
            }
            
        }
        
        return count;
    }
}