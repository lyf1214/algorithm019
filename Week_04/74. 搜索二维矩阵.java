class Solution {
    //思路：将其想象成m x n长度的一维升序数组，然后用二分查找法找到目标元素target
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m * n -1;
        while (left <= right) {
            int mid = (left + right)/2;
            int pivotElement = matrix[mid/n][mid%n];
            //中间支点元素pivotElement== target，找到目标值；若pivotElement>target,则target在左边；否则在右边
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