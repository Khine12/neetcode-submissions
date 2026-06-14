class LRUCache {

    private static final class Node {

        int key, val;

        Node prev, next;

        Node(int k, int v){

            key = k;

            val = v;
        }
    }

    private final int capacity;

    private final Map<Integer,Node> map;

    private final Node right;

    private final Node left;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        this.map = new HashMap<>();

        this.right = new Node(-1,-1);

        this.left = new Node(-1,-1);

        this.left.next = right;

        this.right.prev = left;
    }
    
    public int get(int key) {

        Node node = map.get(key);

        if(node == null) return -1;

        moveToFront(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {

        Node node = map.get(key);

        if(node != null){

            node.val = value;

            moveToFront(node);

            return;
        }

        Node newNode = new Node(key,value);

        map.put(key,newNode);

        addFirst(newNode);

        if(map.size() > capacity){

            Node lru = right.prev;

            remove(lru);

            map.remove(lru.key);
        }
    }

    private void remove(Node node){

        Node a = node.prev;
        Node b = node.next;

        a.next = b;
        b.prev = a;
    }

    private void addFirst(Node node){

        Node first = left.next;

        left.next = node;

        node.prev = left;

        node.next = first;

        first.prev = node;
    }

    private void moveToFront(Node node){

        remove(node);
        addFirst(node);
    }
}
