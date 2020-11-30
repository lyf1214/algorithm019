class Solution {
    //˼·�����������m x n���ȵ�һά�������飬Ȼ���ö��ֲ��ҷ��ҵ�Ŀ��Ԫ��target
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m * n -1;
        while (left <= right) {
            int mid = (left + right)/2;
            int pivotElement = matrix[mid/n][mid%n];
            //�м�֧��Ԫ��pivotElement== target���ҵ�Ŀ��ֵ����pivotElement>target,��target����ߣ��������ұ�
            if(pivotElement == target) return true;
            if(pivotElement > target) {
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}