class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //计算频次
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for(int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        //根据出现的频次排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(new  Comparator<int[]>(){
            public int compare(int[] m, int[] n){
                return m[1] - n[1];//升序
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k){
                if(queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        //取出结果并返回
        int[] res = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}