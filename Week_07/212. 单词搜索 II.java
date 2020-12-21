class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;
    public TrieNode(){}
}
class Solution {
    private char[][] _board = null;
    Set<String> result = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        this._board = board;
        //��һ��������Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            buildTrie(word, root);
        }
        //�ڶ�����DFS����board�����ҳ���������board�еĵ��ʣ������뵽result������
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children.containsKey(board[row][col])){
                    backtracking(row, col, root);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);
        //1���ҵ�����
        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null; 
        }
        this._board[row][col] = '#'; //��ֹ�ظ�ʹ��
        //2���ڸ�����ڵ�board[row][col]��������ɢ�����ݱ���
        int[] rowOffset = {-1, 1, 0, 0};
        int[] colOffset = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            //�ж��Ƿ����
            if(newRow < 0 || newRow >= this._board.length || newCol < 0 || newCol >= this._board[0].length) continue;
            if (currNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }
        this._board[row][col] = letter; //�ָ��õ�ԭֵ
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

    public void buildTrie(String word, TrieNode node) {
        for (Character letter : word.toCharArray()) {
            if (node.children.containsKey(letter)) { //�ýڵ�����ַ�
                node = node.children.get(letter);
            } else {
                TrieNode newNode = new TrieNode();
                node.children.put(letter, newNode);
                node = newNode;
            }
        }
        node.word = word;//�洢����
    }
}