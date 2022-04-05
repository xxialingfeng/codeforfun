package Lab8;

import cs61b.Map61B;

import java.util.*;

public class MyHashMap<K, V> implements Map61B<K, V>{
    private static int initialSize = 16;
    private static double loadFactor = 0.75;
    private int size;
    private int threshold;
    private BucketEntity<K, V>[] buckets;
    private class BucketEntity<K, V>{
        private K k;
        private V v;
        private BucketEntity<K, V> next;

        private BucketEntity(K key, V val, BucketEntity<K,V> next){
            this.k = key;
            this.v = val;
            this.next = next;
        }

        private V get(BucketEntity<K, V> bucketEntity, K key){
            if(bucketEntity == null){
                return null;
            }
            if(bucketEntity.k.equals(key)){
                return bucketEntity.v;
            }
            return get(bucketEntity.next, key);
        }

        private BucketEntity<K, V> put(BucketEntity<K, V> bucketEntity, K key, V val){
            if(bucketEntity == null){
                return new BucketEntity<>(key, val, null);
            }
            if(bucketEntity.k.equals(key)){
                this.v = val;
                return bucketEntity;
            }
            bucketEntity.next = put(bucketEntity.next, key, val);
            return bucketEntity;
        }
    }
    public MyHashMap(){
            this(initialSize,loadFactor);
    }

    public MyHashMap(int initialSize){
            this(initialSize,loadFactor);
    }

    public MyHashMap(int initialSize, double loadFactor){
           if(initialSize < 1 || loadFactor <= 0){
               throw new IllegalArgumentException();
           }
           buckets = new BucketEntity[initialSize];
           this.size = 0;
           this.threshold = (int) (initialSize * loadFactor);
           MyHashMap.initialSize = initialSize;
           MyHashMap.loadFactor = loadFactor;
    }

    public void resize(int capacity){
           BucketEntity<K, V>[] bucketEntities = new BucketEntity[capacity];
           for(int i = 0; i < buckets.length; i++){
               if(buckets[i] == null){
                   continue;
               }
               BucketEntity<K, V> entity = buckets[i];
               while(entity != null){
                   int hash = hash(entity.k, capacity);
                   if(bucketEntities[hash] == null){
                       bucketEntities[hash] = new BucketEntity<>(entity.k, entity.v, null);
                   }else{
                       bucketEntities[hash].put(bucketEntities[hash], entity.k, entity.v);
                   }
                   entity = entity.next;
               }
           }
           this.buckets = bucketEntities;
           this.threshold = (int)(capacity * loadFactor);
    }

    private int hash(K key){
        return hash(key, buckets.length);
    }

    private int hash(K key, int capacity){
        return (key.hashCode() & 0x7fffffff) & capacity;
    }
    @Override
    public void clear() {
        this.buckets = new BucketEntity[initialSize];
        this.size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        if(key == null){
            throw new IllegalArgumentException();
        }
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        if(key == null){
            throw new IllegalArgumentException();
        }
        int i = hash(key);
        if(this.buckets[i] == null){
            return null;
        }
        return this.buckets[i].get(this.buckets[i], key);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if(key == null){
            throw new IllegalArgumentException();
        }
        if(!containsKey(key)){
            this.size += 1;
        }
        int i = hash(key);
        if(this.buckets[i] == null){
            this.buckets[i] = new BucketEntity<>(key, value, null);
        }else{
            this.buckets[i].put(this.buckets[i], key, value);
        }

        if(size > threshold){
            resize(buckets.length * 2);
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] == null){
                continue;
            }
            BucketEntity<K, V> bucket = buckets[i];
            while(bucket != null){
                keySet.add(bucket.k);
                bucket = bucket.next;
            }
        }
        return keySet;
    }

    @Override
    public V remove(K key) {
        return remove(key, get(key));
    }

    @Override
    public V remove(K key, V value) {
        if(key == null){
            throw new IllegalArgumentException();
        }
        V toremove = get(key);
        if(!containsKey(key) || toremove != value ){
            return null;
        }
        int hash = hash(key);
        BucketEntity bucket = this.buckets[hash];
        if(bucket.next == null){
            this.buckets[hash] = null;
            this.size -= 1;
        }else{
            while(bucket.next != null){
                if(bucket.next.k == key){
                    bucket.next = bucket.next.next;
                    this.size -= 1;
                    break;
                }
            }
        }
        return toremove;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}
