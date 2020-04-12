package com.arunav.dsalgo.hashtable;

public class DoubleHashingHashTable<K, V> extends OpenAddressingHashTable<K, V> {

    private int primeNumber;

    DoubleHashingHashTable() {
        super();
        primeNumber = -1;
    }

    @Override
    protected int hashFunc2(K key, int i) {
        if (primeNumber == -1 || hasBucketSizeChanged) {
            primeNumber = getPrimeNumber(this.getBucketSize());
            hasBucketSizeChanged = false;
        }
        return i * primeNumber - (key.hashCode() % primeNumber);
    }

    private int getPrimeNumber(int bucketSize) {
        int num = bucketSize;
        boolean primeNumFound = false;
        while (num > 1) {
            int i = 2;
            primeNumFound = true;
            while (i <= num / 2) {
                if (num % i == 0) {
                    primeNumFound = false;
                    break;
                }
                i++;
            }
            if (primeNumFound)
                return num;
            num--;
        }
        return num;
    }
}
