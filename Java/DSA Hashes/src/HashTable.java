// ********************************************************
// Hash table implementation.
// Assumption: A table contains unique items(at most one
//             item with a given search key at any time)
// *********************************************************

public class HashTable<K, V> implements HashTableInterface<K,V> {
    private ChainNode<K, V>[] table;     // hash table
    private int size = 0;          // size of ADT table

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new ChainNode[3];
    }  // end default constructor

    // table operations
    public boolean tableIsEmpty() {
        return size==0;
    }  // end tableIsEmpty

    public int tableLength() {
        return size;
    }  // end tableLength


    //implement the following 4 methods
    @Override
    public void tableInsert(K key, V value) throws HashException {
        int index = hashIndex(key);

        ChainNode<K,V> wasThere = table[index];
        table[index] = new ChainNode<K,V>(key,value,wasThere);

        size++;
    }	// end tableInsert


    public boolean tableDelete(K searchKey)	{
        int index = hashIndex(searchKey);
        boolean found = false;

        ChainNode<K,V> current = table[index];
        ChainNode<K,V> previous = null;

        if (current != null && current.getKey().equals(searchKey)) {
            table[index] = current.getNext();
            found = true;
            size--;
        }	// end if
        else {
            previous = current;
            current = current.getNext();

            while (current != null && !found) {
                previous = current;
                current = current.getNext();

                if (current.getKey().equals(searchKey)) {
                    found = true;
                    previous.setNext(current.getNext());
                    size--;
                }	// end if
                else {
                    previous = current;
                    current = current.getNext();
                }	// end else
            }	// end while
        }	// end else

        return found;
    }	// end tableDelete


    public V tableRetrieve(K searchKey)	{
        int index = hashIndex(searchKey);
        boolean found = false;
        V toReturn = null;

        if (tableIsEmpty()) {
            System.out.println("Table is empty, cannot retrieve!");
        }	// end if
        else {
            for (ChainNode<K,V> current = table[index]; current != null && !found; current = current.getNext()) {
                if (current.getKey().equals(searchKey)) {
                    found = true;
                    toReturn = current.getValue();
                }	// end if
            }	// end while
        }	// end else
        return toReturn;
    }	// end tableRetrieve


    public int hashIndex(K key)	{
        int hashed = 0;	// the hash value for the input key

        char[] keyInput = key.toString().toCharArray();

        for (int i = 0; i < keyInput.length; i++) {

            hashed += (Character.compare(keyInput[i], 'A') + 1) << 5*i;	// map each character to the corresponding integer

        }	// end for

        hashed = hashed % table.length;

        return hashed;
    }	// end hashIndex
}  // end HashTable
