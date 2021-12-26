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
        // .contains() has O(1) time complexity
        if (!hashSet.contains(node)) {
            // condition where cache is full and we need to remove something
            if (doublyQueue.size() == CACHE_SIZE) {
                Node last = doublyQueue.removeLast();       // Least recently used page or data is removed
                hashSet.remove(last);
            }
        } else {
            doublyQueue.remove(node);
        }
        doublyQueue.push(node);                             // make the new node as the most recently used
        hashSet.add(node);                                  // add it to hashset also
    }

    public void display() {
        System.out.println("Displaying Cached data : ");
        Iterator<Node> itr = doublyQueue.iterator();
        while (itr.hasNext()) {
            itr.next().displayNodeData();
        }
    }
}