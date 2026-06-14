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

    private final Node most_recent;

    private final Node least_recent;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;

        this.map = new HashMap<>();

        most_recent = new Node(-1,-1);

        least_recent = new Node(-1,-1);

        most_recent.next = least_recent;

        least_recent.prev = most_recent;
    }
    
    public int get(int key) {

        Node node = map.get(key);

        if(node == null) return -1;

        moveToFirst(node);

        return node.val;
    }
    
    public void put(int key, int value) {

        Node node = map.get(key);

        if(node != null){

            node.val = value;

            moveToFirst(node);

            return;
        }

        Node new_node = new Node(key,value);
        
        map.put(key,new_node);

        addFirst(new_node);

        if(map.size() > capacity){

            node = least_recent.prev;

            remove(node);

            map.remove(node.key);
        }
        
    }

    private void remove(Node node){

        Node a = node.prev;

        Node b = node.next;

        a.next = b;

        b.prev = a;
    }

    private void addFirst(Node node){

        Node first = most_recent.next;

        most_recent.next = node;

        node.prev = most_recent;

        node.next = first;

        first.prev = node;
    }

    private void moveToFirst(Node node){

        remove(node);

        addFirst(node);
    }
}
