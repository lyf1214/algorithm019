class Solution {
    private final int L = 9;
    public boolean isValidSudoku(char[][] board) {
        //rows存储每行值(rows[行][值])  cols存储每列值(cols[列][值]) boxes存储每格子值(boxes[格子下标][值])
        //若值在行rows、列cols、格子boxes已存在，说明不是有效数独，返回false
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
                //判断值在行、列、格子中是否存在
                if (rows[r][valueIndex] == value || cols[c][valueIndex] == value || boxes[boxIndex][valueIndex] == value) {
                    return false;
                }
                //将未出现的值加入到对应的行、列、格子中
                rows[r][valueIndex] = value;
                cols[c][valueIndex] = value;
                boxes[boxIndex][valueIndex] = value;
            }
        }
        return true;
    }
}