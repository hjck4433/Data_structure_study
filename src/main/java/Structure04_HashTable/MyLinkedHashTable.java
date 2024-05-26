package Structure04_HashTable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedHashTable<K, V> implements IHashTable<K, V> {
    private static final int DEFAULT_BUCKET_SIZE = 1024;

    private List<Node>[] buckets;
    private int size;
    private int bucketSize;

    public MyLinkedHashTable() {
        this.buckets = new List[DEFAULT_BUCKET_SIZE];
        this.bucketSize = DEFAULT_BUCKET_SIZE;
        this.size = 0;
        for (int i = 0; i < bucketSize; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    public MyLinkedHashTable(int bucketSize) {
        this.buckets = new List[bucketSize];
        this.bucketSize = bucketSize;
        this.size = 0;
        for (int i = 0; i < bucketSize; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }
    @Override
    public void put(K key, V value) {
        // 해시 함수로 인덱스값 구함
        int idx = this.hash(key);
        // 해당 인덱스의 버킷
        List<Node> bucket = this.buckets[idx];
        // 이미 해당 인덱스에 해당 키가 있다면 값 변경
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.data = value;
                return;
            }
        }
        // 비어있는 인덱스라면 키, 값을 가진 새 노드 생성
        Node node = new Node(key, value);
        // 해당 버킷에 노드 추가
        bucket.add(node);
        // 사이즈 증가
        this.size++;
    }

    @Override
    public V get(K key) {
        // 해시 함수로 인덱스값 구함
        int idx = this.hash(key);
        // 해당 인덱스의 버킷
        List<Node> bucket = this.buckets[idx];
        // 해당 버킷에 key에 해당하는 노드가 있다면 노드의 데이터 반환
        for (Node node: bucket) {
            if (node.key.equals(key)){
                return node.data;
            }
        }
        return null;
    }

    @Override
    public boolean delete(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Iterator<Node> iter = bucket.iterator(); iter.hasNext();) {
            Node node = iter.next();
            if(node.key.equals(key)) {
                iter.remove();
                this.size--;
            }
        }
        return false;
    }

    @Override
    public boolean contains(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Node node : bucket) {
           if (node.key.equals(key)) {
               return true;
           }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
    private int hash(K key) {
      int hash = 0;
      for (Character ch: key.toString().toCharArray()) {
          hash += (int) ch;
      }
      return hash % this.bucketSize;
    };

    private class Node {
        K key;
        V data;

        Node(K key, V value) {
            this.key = key;
            this.data = value;
        }
    }
}
