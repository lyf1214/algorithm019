class Solution {
    private final int L = 9;
    public boolean isValidSudoku(char[][] board) {
        //rows�洢ÿ��ֵ(rows[��][ֵ])  cols�洢ÿ��ֵ(cols[��][ֵ]) boxes�洢ÿ����ֵ(boxes[�����±�][ֵ])
        //��ֵ����rows����cols������boxes�Ѵ��ڣ�˵��������Ч����������false
        int[][] rows = new int[L][L];
        int[][] cols = new int[L][L];
        int[][] boxes = new int[L][L];
        for (int r = 0; r < L; r++) {
            for (int c = 0; c < L; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int value = board[r][c] - '0';
                int valueIndex = value - 1;
                int boxIndex = r / 3 *3 + c / 3;
                //�ж�ֵ���С��С��������Ƿ����
                if (rows[r][valueIndex] == value || cols[c][valueIndex] == value || boxes[boxIndex][valueIndex] == value) {
                    return false;
                }
                //��δ���ֵ�ֵ���뵽��Ӧ���С��С�������
                rows[r][valueIndex] = value;
                cols[c][valueIndex] = value;
                boxes[boxIndex][valueIndex] = value;
            }
        }
        return true;
    }
}