class Solution {
    //BFS 
    //思路：构建图，BFS遍历每一层，直到找到endWorld或者遍历到最后一层
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size()==0 || !wordList.contains(endWord)) {
            return 0;
        }
        //1、将元素添加到哈希表中,便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        //2、图的广度优先遍历，必须使用队列和是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) { 
            int currentLevelSize = queue.size();
            //System.out.println("currentLevelSize=="+currentLevelSize+"---step="+step);
            for (int i = 0; i < currentLevelSize; i++) {
                String currentWord = queue.poll();
                //如果currentWord改变一个字符等于endWorld,则转换步骤为step + 1
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
            currentCharArray[i] = originChar; //恢复原来字符
        }
        return false;
    }
}