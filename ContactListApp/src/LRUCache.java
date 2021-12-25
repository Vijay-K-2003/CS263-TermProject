package CS263;

import java.util.*;

public class LRUCache {

    private Deque<Node> doublyQueue;
    private HashSet<Node> hashSet;
    private final int CACHE_SIZE;

    LRUCache(int capacity) {
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }

    public void refer(Node node) {
        if (!hashSet.contains(node)) {
            if (doublyQueue.size() == CACHE_SIZE) {
                Node last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        } else {
            doublyQueue.remove(node);
        }
        doublyQueue.push(node);
        hashSet.add(node);
    }

    public void display() {
        System.out.println("Displaying Cached data : ");
        Iterator<Node> itr = doublyQueue.iterator();
        while (itr.hasNext()) {
            itr.next().displayNodeData();
        }
    }
}