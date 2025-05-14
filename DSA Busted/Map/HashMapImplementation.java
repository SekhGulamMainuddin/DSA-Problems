package Map;

import java.util.LinkedList;
import java.util.ArrayList;

/*
 * Custom implementation of a generic HashMap<K, V>
 * using separate chaining with LinkedLists for collision handling.
 */
public class HashMapImplementation {

    // Custom generic HashMap class
    static class CustomHashMap<K, V> {

        // Inner class to represent a key-value pair (node)
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // Total number of key-value pairs
        private int N; // Number of buckets (i.e., length of the buckets array)
        private LinkedList<Node>[] buckets; // Array of LinkedLists (buckets)

        // Constructor to initialize with default bucket size
        @SuppressWarnings("unchecked")
        public CustomHashMap() {
            this.N = 4; // Initial number of buckets
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // Hash function to compute the index of the bucket for a given key
        private int hashFunction(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % N;
        }

        // Searches for a key in a specific bucket and returns its index
        // Returns -1 if not found
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i; // Found the key, return its index
                }
            }

            return -1; // Key not found
        }

        // Rehashing: When load factor exceeds threshold, double the bucket array size
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2; // Update bucket count

            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            n = 0; // Reset node count and reinsert existing nodes

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value); // Reinsert node
                }
            }
        }

        // Inserts or updates a key-value pair
        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                // Key doesn't exist; add new node
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                // Key exists; update value
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            // Load factor = number of elements / number of buckets
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash(); // Rehash if load factor exceeds threshold
            }
        }

        // Checks if the map contains a key
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        // Removes a key-value pair and returns the value
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return null; // Key doesn't exist
            } else {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        // Gets the value associated with a key
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                return null; // Key doesn't exist
            } else {
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        // Returns all keys in the HashMap
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    keys.add(ll.get(j).key);
                }
            }

            return keys;
        }

        // Checks if the map is empty
        public boolean isEmpty() {
            return n == 0;
        }
    }

    // Main method to test the HashMap implementation
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        // Print all key-value pairs
        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }

        // Remove a key and attempt to fetch its value
        map.remove("India");
        System.out.println("After removing India: " + map.get("India")); // Should print null
    }
}
