class Solution {
    //BFS 
    //˼·������ͼ��BFS����ÿһ�㣬ֱ���ҵ�endWorld���߱��������һ��
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size()==0 || !wordList.contains(endWord)) {
            return 0;
        }
        //1����Ԫ����ӵ���ϣ����,�����ж�ĳ�������Ƿ��� wordList ��
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        //2��ͼ�Ĺ�����ȱ���������ʹ�ö��к��Ƿ���ʹ��� visited ��ϣ��
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();

        // �� 3 ������ʼ������ȱ�����������㣬��˳�ʼ����ʱ����Ϊ 1
        int step = 1;
        while (!queue.isEmpty()) { 
            int currentLevelSize = queue.size();
            //System.out.println("currentLevelSize=="+currentLevelSize+"---step="+step);
            for (int i = 0; i < currentLevelSize; i++) {
                String currentWord = queue.poll();
                //���currentWord�ı�һ���ַ�����endWorld,��ת������Ϊstep + 1
                if (changeWorldEveryOneLetter(currentWord, endWord, visited,wordSet,queue)) {
                    //System.out.println("--step+1=="+(step +1));
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    public boolean changeWorldEveryOneLetter(String currentWord, String endWord, Set<String> visited, Set<String> wordSet, Queue<String> queue) {
        char[] currentCharArray = currentWord.toCharArray();
        for ( int i = 0; i < currentCharArray.length; i++) {
            char originChar = currentCharArray[i];
            for ( char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                currentCharArray[i] = k;
                String nextWorld = String.valueOf(currentCharArray);
                if (wordSet.contains(nextWorld)) {
                    if (Objects.equals(nextWorld, endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWorld)) {
                        queue.add(nextWorld);
                        visited.add(nextWorld);
                    }
                }
            }
            currentCharArray[i] = originChar; //�ָ�ԭ���ַ�
        }
        return false;
    }
}