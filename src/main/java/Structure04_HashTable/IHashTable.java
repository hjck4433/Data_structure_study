package Structure04_HashTable;

public interface IHashTable<K, V> {
    public void put(K key, V value);

    public V get(K key);

    public boolean delete(K key);

    public boolean contains(K key);

    public int size();
}
