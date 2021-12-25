import java.util.*;

public class LRUCache {

    private Deque<Node> doublyQueue;
    private HashSet<Node> hashSet;
    private final int CACHE_SIZE;
    LRUCache(int capacity) {
        // we create a Linked List and HashSet
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }

    public void refer(Node node) {
        // if the hashset does not contain node then we should
        // push the new node to cache if it has not exceeded the cache size
        // else we will remove the node and add it to the linked list again
        if (!hashSet.contains(node)) {
            if (doublyQueue.size() == CACHE_SIZE) {
                Node last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        }
        else {
            doublyQueue.remove(node);
        }
        doublyQueue.push(node);
        hashSet.add(node);
    }

    public void display() {
        System.out.println("Displaying Cached data : ");
        Iterator<Node> itr = doublyQueue.iterator();
        // we have the iterator that will iterate through
        // the linked list and then display each node data.
        while (itr.hasNext()) {
            itr.next().displayNodeData();
        }
    }
}