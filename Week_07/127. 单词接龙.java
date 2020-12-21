class Solution {
    //1��BFS
    //2��DFS
    //3��˫��BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //˼·��˫��BFS
        //1����Ԫ����ӵ���ϣ����,�����ж�ĳ�������Ƿ��� wordList ��
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; 

        //2����¼���ʹ���word��visited��ϣ���У���ֹ�ظ�����
        Set<String> visited = new HashSet<>();
        //3���ֱ�����ߺ��ұ���ɢ�Ĺ�ϣ����浥�� BFS ��Ķ��У�������˫�� BFS �Ĺ����н���ʹ��
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        //4��ִ��˫�� BFS��ͨ��ѡ���С�Ĺ�ϣ�������������һ��Ԫ�أ�ʵ�����ҽ���˫��ִ�У����ҽ�����ɢ�Ĳ���֮�ͼ�Ϊ��̳���
        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //����ѡ��С�Ĺ�ϣ����������ǵ��������
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            //BFS���ҵ���һ���Ԫ�أ����Ƿ�������endSet�У�������endSet,˵�����ҵ�
            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginSet) {
                if (changeWorldEveryOneLetter(word, wordSet, endSet, nextLevelSet, visited)) {
                    System.out.println("word==="+word);
                    return step + 1;
                } 
            }
            beginSet = nextLevelSet;
            step++;
        }
        return 0;
    }

    public boolean changeWorldEveryOneLetter(String currentWord, Set<String> wordSet, Set<String> endSet, Set<String> nextLevelSet, Set<String> visited) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char originChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originChar) continue;
                charArray[i] = c;
                String newWord = String.valueOf(charArray);
                //���ʼ���wordSet�����µ��ʣ�˵��Ϊ��һ��Ԫ��
                if(wordSet.contains(newWord)) {
                    //endSet������Ԫ�أ��ҵ�����Ҫ���·��
                    if (endSet.contains(newWord)) {
                        return true;
                    }
                    if (!visited.contains(newWord)) {
                        visited.add(newWord);
                        nextLevelSet.add(newWord);
                    }
                }
            }
            //�ָ����ʣ��´�ʹ��
            charArray[i] = originChar;
        }
        return false;
    }
}


// class Solution {
//     //BFS 
//     //˼·������ͼ��BFS����ÿһ�㣬ֱ���ҵ�endWorld���߱��������һ��
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         if (wordList.size()==0 || !wordList.contains(endWord)) {
//             return 0;
//         }
//         //1����Ԫ����ӵ���ϣ����,�����ж�ĳ�������Ƿ��� wordList ��
//         Set<String> wordSet = new HashSet<>(wordList);
//         wordSet.remove(beginWord);
//         //2��ͼ�Ĺ�����ȱ���������ʹ�ö��к��Ƿ���ʹ��� visited ��ϣ��
//         Queue<String> queue = new LinkedList<>();
//         queue.offer(beginWord);
//         Set<String> visited = new HashSet<>();

//         // �� 3 ������ʼ������ȱ�����������㣬��˳�ʼ����ʱ����Ϊ 1
//         int step = 1;
//         while (!queue.isEmpty()) { 
//             int currentLevelSize = queue.size();
//             //System.out.println("currentLevelSize=="+currentLevelSize+"---step="+step);
//             for (int i = 0; i < currentLevelSize; i++) {
//                 String currentWord = queue.poll();
//                 //���currentWord�ı�һ���ַ�����endWorld,��ת������Ϊstep + 1
//                 if (changeWorldEveryOneLetter(currentWord, endWord, visited,wordSet,queue)) {
//                     //System.out.println("--step+1=="+(step +1));
//                     return step + 1;
//                 }
//             }
//             step++;
//         }
//         return 0;
//     }

//     public boolean changeWorldEveryOneLetter(String currentWord, String endWord, Set<String> visited, Set<String> wordSet, Queue<String> queue) {
//         char[] currentCharArray = currentWord.toCharArray();
//         for ( int i = 0; i < currentCharArray.length; i++) {
//             char originChar = currentCharArray[i];
//             for ( char k = 'a'; k <= 'z'; k++) {
//                 if (k == originChar) {
//                     continue;
//                 }
//                 currentCharArray[i] = k;
//                 String nextWorld = String.valueOf(currentCharArray);
//                 if (wordSet.contains(nextWorld)) {
//                     if (Objects.equals(nextWorld, endWord)) {
//                         return true;
//                     }
//                     if (!visited.contains(nextWorld)) {
//                         queue.add(nextWorld);
//                         visited.add(nextWorld);
//                     }
//                 }
//             }
//             currentCharArray[i] = originChar; //�ָ�ԭ���ַ�
//         }
//         return false;
//     }
// }