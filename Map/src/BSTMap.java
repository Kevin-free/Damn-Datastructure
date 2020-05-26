/**
 * @description: 基于二分搜索树实现的映射
 * @author: Kevin
 * @createDate: 2020/2/20
 * @version: 1.0
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node,K key,V value){
        if (node == null) {
            size ++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node, key, value);
        }else{
            node.value = value;
        }
        return node;
    }

    private Node getNode(Node node,K key){
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        }else {
            return getNode(node.right, key);
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            node = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node,K key){
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }else{
            if (node.left == null) {
                Node rNode = node.right;
                node.right = null;
                size--;
                return rNode;
            }
            if (node.right == null) {
                Node lNode = node.left;
                node.left = null;
                size--;
                return lNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rNode = node.right;
            node.right = null;
            size--;
            return rNode;
        }
        node.left = removeMin(node.left);
        return node;

    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "does not exsit!");
        }else{
            node.value = newValue;
        }
    }

}
