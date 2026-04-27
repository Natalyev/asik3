import java.util.Iterator;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Entry> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left;
        private Node right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }

        return node;
    }

    public V get(K key) {
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }

        return null;
    }

    public void delete(K key) {
        if (get(key) != null) {
            root = delete(root, key);
            size--;
        }
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            Node min = findMin(node.right);

            node.key = min.key;
            node.val = min.val;

            node.right = deleteMin(node.right);
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        return node;
    }

    public int size() {
        return size;
    }

    public Iterator<Entry> iterator() {
        Entry[] arr = new BST.Entry[size];
        int[] index = {0};
        inOrder(root, arr, index);

        return new Iterator<Entry>() {
            private int current = 0;

            public boolean hasNext() {
                return current < arr.length;
            }

            public Entry next() {
                return arr[current++];
            }
        };
    }

    private void inOrder(Node node, Entry[] arr, int[] index) {
        if (node == null) {
            return;
        }

        inOrder(node.left, arr, index);
        arr[index[0]] = new Entry(node.key, node.val);
        index[0]++;
        inOrder(node.right, arr, index);
    }
}