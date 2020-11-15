class Solution {

     public int[] twoSum(int[] nums, int target) {
         //1���������  ˫ѭ�� ʱ�临�Ӷ�O(n^2)
        // int[] result = new int[2];
        // for (int i=0; i<nums.length; i++) {
        //     for (int j=i+1; j<nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             result[0] = i;
        //             result[1] = j;
        //             return result;
        //         }
        //     }
        // }
        // return result;

        //2��ʹ�ù�ϣ��  ʱ�临�Ӷ�O(n)
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[] {hashtable.get(target - nums[i]), i };
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
     }
}