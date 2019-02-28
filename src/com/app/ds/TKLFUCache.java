package com.app.ds;

import java.util.*;

public class TKLFUCache<K, V> {

    private static final Object DUMMY = new Object();
    public Map<K, CacheEntry> cacheMap = new HashMap<>();
    public Map<Integer, LRUCache> frequencyMap = new HashMap<>();

    private int MAX_CACHE_SIZE = 5;

    private int MIN_FREQUENCY = 1;
    public transient int lowestFrequency = MIN_FREQUENCY;
    private int MAX_FREQUENCY = Integer.MAX_VALUE;

    public TKLFUCache() {
        frequencyMap.put(MIN_FREQUENCY, new LRUCache());
    }

    public static void main(String[] args) {
        TKLFUCache<String, String> cache = new TKLFUCache<>();
        cache.put("Tarun4", "Walia");
        cache.put("Tarun4", "Walia2");
        //  cache.get("Tarun4");
        //  cache.get("Tarun4");

        cache.put("Tarun41", "Walia");
        // cache.put("Tarun41", "Walia2");
        // cache.get("Tarun41");
        // cache.get("Tarun41");

        cache.put("Tarun42", "Walia");
        cache.put("Tarun42", "Walia2");
        cache.get("Tarun42");
        //cache.get("Tarun42");

        cache.put("Tarun2", "Walia");
        cache.get("Tarun2");

        // cache.put("Tarun21", "Walia");
        // cache.get("Tarun21");


        cache.put("Q1", "Q1");
        cache.put("Q2", "Q2");

        cache.put("Q4", "Q1");
        cache.put("Q4", "Q2");

//        cache.remove("Q1");
//        cache.remove("Q2");

        cache.get("Tarun42");

        cache.put("AA", "AA");


        // cache.printFrequencyMap();
        cache.printCache();
        System.out.println(" *****Low Freq*****" + cache.lowestFrequency);

        System.out.println(" ****Cache Size******* " + cache.cacheMap.size());

    }

    public void printFrequencyMap() {
        Set<Map.Entry<Integer, LRUCache>> set = frequencyMap.entrySet();
        for (Map.Entry<Integer, LRUCache> fen : set) {
            System.out.println(fen.getKey() + " *** " + fen.getValue().toString());
        }
    }

    public void printCache() {
        Set<Map.Entry<K, CacheEntry>> set = cacheMap.entrySet();
        for (Map.Entry<K, CacheEntry> fen : set) {
            System.out.println(fen.getKey() + " *** " + fen.getValue().toString());
        }
    }


    /**
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {

        CacheEntry<K, V> oldEntry = cacheMap.get(key);
        if (oldEntry == null) {
            CacheEntry<K, V> newEntry = new CacheEntry<>(key);
            newEntry.value = value;
            cacheMap.put(key, newEntry);
            if (frequencyMap.get(MIN_FREQUENCY) == null) {
                frequencyMap.put(MIN_FREQUENCY, new LRUCache());
            }
            frequencyMap.get(MIN_FREQUENCY).put(newEntry, DUMMY);
            lowestFrequency = MIN_FREQUENCY;
            return newEntry.value;
        } else {
            V oldValue = oldEntry.value;
            oldEntry.value = value;
            replace(key, oldEntry);
            return oldValue;
        }
    }

    /**
     * @param key
     * @return
     */
    public V remove(K key) {
        CacheEntry<K, V> oldEntry = cacheMap.get(key);
        if (oldEntry != null) {
            frequencyMap.get(oldEntry.frequency).remove(oldEntry);
            if (frequencyMap.get(oldEntry.frequency).isEmpty()) {
                frequencyMap.remove(oldEntry.frequency);
                if (lowestFrequency == oldEntry.frequency) {
                    lowestFrequency = oldEntry.frequency + 1;
                }
            }
            cacheMap.remove(key);
            return oldEntry.value;
        }
        return null;
    }

    private void replace(K key, CacheEntry<K, V> oldEntry) {
        if (lowestFrequency >= oldEntry.frequency) {
            lowestFrequency = oldEntry.frequency;
        }
        frequencyMap.get(oldEntry.frequency).remove(oldEntry);
        if (frequencyMap.get(oldEntry.frequency).isEmpty()) {
            frequencyMap.remove(oldEntry.frequency);
            if (lowestFrequency == oldEntry.frequency) {
                lowestFrequency = oldEntry.frequency + 1;
            }
        }
        int nextFrequency = ++oldEntry.frequency;
        if (!frequencyMap.containsKey(nextFrequency)) {
            frequencyMap.put(nextFrequency, new LRUCache());
        }
        frequencyMap.get(nextFrequency).put(oldEntry, DUMMY);
        cacheMap.put(key, oldEntry);
    }

    /**
     * @param key
     * @return
     */
    public V get(K key) {
        CacheEntry<K, V> oldEntry = cacheMap.get(key);
        if (oldEntry != null) {
            replace(key, oldEntry);
            return oldEntry.value;

        }
        return null;
    }

    class CacheEntry<K, V> {
        K key;
        V value;
        int frequency = MIN_FREQUENCY;

        public CacheEntry(K key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheEntry that = (CacheEntry) o;
            return Objects.equals(key, that.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "CacheEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", frequency=" + frequency +
                    '}';
        }
    }

    class LRUCache extends LinkedHashMap<CacheEntry, Object> {

        static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

        static final float DEFAULT_LOAD_FACTOR = 0.75f;

        public LRUCache() {
            super(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, true);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<CacheEntry, Object> eldest) {
            if (cacheMap.size() > MAX_CACHE_SIZE) {
                if (this.size() > 1) {
                    cacheMap.remove(eldest.getKey().key);
                    return true;
                } else {
                    CacheEntry entry = new CacheEntry(DUMMY);
                    frequencyMap.get(lowestFrequency).put(entry, DUMMY);
                    frequencyMap.get(lowestFrequency).remove(entry);
                    return false;
                }
            }
            return false;
        }
    }
}
