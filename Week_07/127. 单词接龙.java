class Solution {
    //1、BFS
    //2、DFS
    //3、双向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //思路：双向BFS
        //1、将元素添加到哈希表中,便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; 

        //2、记录访问过的word到visited哈希表中，防止重复访问
        Set<String> visited = new HashSet<>();
        //3、分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        //4、执行双向 BFS，通过选择较小的哈希表遍历查找其下一层元素，实现左右交替双向执行；左右交替扩散的步数之和即为最短长度
        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //优先选择小的哈希表遍历，考虑的情况更少
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            //BFS：找到下一层的元素，看是否落在了endSet中，若落在endSet,说明已找到
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
                //单词集合wordSet包含新单词，说明为下一层元素
                if(wordSet.contains(newWord)) {
                    //endSet包含该元素，找到符合要求的路径
                    if (endSet.contains(newWord)) {
                        return true;
                    }
                    if (!visited.contains(newWord)) {
                        visited.add(newWord);
                        nextLevelSet.add(newWord);
                    }
                }
            }
            //恢复单词，下次使用
            charArray[i] = originChar;
        }
        return false;
    }
}


// class Solution {
//     //BFS 
//     //思路：构建图，BFS遍历每一层，直到找到endWorld或者遍历到最后一层
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         if (wordList.size()==0 || !wordList.contains(endWord)) {
//             return 0;
//         }
//         //1、将元素添加到哈希表中,便于判断某个单词是否在 wordList 里
//         Set<String> wordSet = new HashSet<>(wordList);
//         wordSet.remove(beginWord);
//         //2、图的广度优先遍历，必须使用队列和是否访问过的 visited 哈希表
//         Queue<String> queue = new LinkedList<>();
//         queue.offer(beginWord);
//         Set<String> visited = new HashSet<>();

//         // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
//         int step = 1;
//         while (!queue.isEmpty()) { 
//             int currentLevelSize = queue.size();
//             //System.out.println("currentLevelSize=="+currentLevelSize+"---step="+step);
//             for (int i = 0; i < currentLevelSize; i++) {
//                 String currentWord = queue.poll();
//                 //如果currentWord改变一个字符等于endWorld,则转换步骤为step + 1
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
//             currentCharArray[i] = originChar; //恢复原来字符
//         }
//         return false;
//     }
// }