import java.util.*;

class LRUCache {

    private class DLLNode {
        int key, value;
        DLLNode prev, next;

        DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int maxCapacity;
    private HashMap<Integer, DLLNode> cache;
    private DLLNode head, tail;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        cache = new HashMap<>();

        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        DLLNode node = cache.get(key);
        detach(node);
        attachToEnd(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLLNode existing = cache.get(key);
            existing.value = value;
            detach(existing);
            attachToEnd(existing);
        } else {
            if (cache.size() == maxCapacity) {
                DLLNode lru = head.next;
                detach(lru);
                cache.remove(lru.key);
            }
            DLLNode newNode = new DLLNode(key, value);
            cache.put(key, newNode);
            attachToEnd(newNode);
        }
    }

    private void detach(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void attachToEnd(DLLNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}
