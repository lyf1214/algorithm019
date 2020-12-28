//1��Java�Դ�������
// class LRUCache extends LinkedHashMap<Integer, Integer>{
//     private int capacity;

//     public LRUCache(int capacity) {
//         super(capacity, 0.75F, true);
//         this.capacity = capacity;
//     }
    
//     public int get(int key) {
//         return super.getOrDefault(key, -1);
//     }
    
//     public void put(int key, int value) {
//         super.put(key, value);
//     }

//     @Override
//     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//         return size() > capacity;
//     }
// }

//2����ϣ + ˫������(������Java API���Լ�ʵ��)
class LRUCache {
    //1������˫�˶�����
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //2��ʵ��LRUCache��get��put�Ȳ���
    //cache�洢hashֵkey��Ԫ��DLinkedNode֮��Ĺ�ϵ
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //ʹ��αͷ����αβ��
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //�������key,��ͨ����ϣ��λ�����ƶ�������ͷ��
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //���key�����ڣ��½�һ���ڵ㣬�����뵽����ͷ��
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            //System.out.println("���head֮��cache==" + cache.size());
            size++;
            if (size > capacity) {
                //�������������ɾ��˫�������β�ڵ�
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            //���key���ڣ����ڵ��Ƶ�����ͷ��
            node.value = value;
            moveToHead(node);
        }
    }

    public void addToHead(DLinkedNode node) {
        //���node�ڵ�ָ���ǰһ���ڵ��ָ��ĺ�һ���ڵ�
        node.pre = head;
        node.next = head.next;
        //������һͷ�ڵ㣬��head.next�ڵ��ָ��
        head.next.pre = node;
        head.next = node;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(DLinkedNode node) {
        //�ı�node�ڵ�ǰһ���ڵ�ͺ�һ���ڵ�ָ��
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public DLinkedNode removeTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */