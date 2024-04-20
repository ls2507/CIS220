public class QuadraticProbing {
    private int[] table;
    private int size;
    private final int capacity = 16;
    private final int c1 = 1;
    private final int c2 = 1;
    private final int EMPTY_START = -1;
    private final int EMPTY_AFTER_REMOVAL = -2;

    public QuadraticProbing() {
        table = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = EMPTY_START;
        }
        size = 0;
    }

    private int hash(int key) {
        return key % capacity;
    }

    private int probe(int key, int i) {
        return (hash(key) + c1 * i + c2 * i * i) % capacity;
    }

    public boolean insert(int key) {
        if (size == capacity)
            return false; // table is full

        int index = hash(key);
        int i = 0;
        while (table[index] != EMPTY_START && table[index] != EMPTY_AFTER_REMOVAL) {
            index = probe(key, ++i);
        }
        table[index] = key;
        size++;
        return true;
    }

    public boolean remove(int key) {
        int index = search(key);
        if (index == -1)
            return false; // key not found

        table[index] = EMPTY_AFTER_REMOVAL;
        size--;
        return true;
    }

    public int search(int key) {
        int index = hash(key);
        int i = 0;
        while (table[index] != key && table[index] != EMPTY_START) {
            index = probe(key, ++i);
        }
        if (table[index] == key)
            return index;
        return -1; // key not found
    }

    public void displayContents() {
        System.out.println("Hash Table Contents:");
        for (int i = 0; i < capacity; i++) {
            System.out.println("Hash Table " + i + ": " + (table[i] == EMPTY_START ? -1 : (table[i] == EMPTY_AFTER_REMOVAL ? -2 : table[i])));
        }
    }

    public static void main(String[] args) {
        QuadraticProbing hashTable = new QuadraticProbing();

        System.out.println("Inserting item 32: " + (hashTable.insert(32) ? "Success" : "Failed"));
        System.out.println("Inserting item 63: " + (hashTable.insert(63) ? "Success" : "Failed"));
        System.out.println("Inserting item 16: " + (hashTable.insert(16) ? "Success" : "Failed"));
        System.out.println("Inserting item 3: " + (hashTable.insert(3) ? "Success" : "Failed"));
        System.out.println("Inserting item 23: " + (hashTable.insert(23) ? "Success" : "Failed"));
        System.out.println("Inserting item 11: " + (hashTable.insert(11) ? "Success" : "Failed"));
        System.out.println("Inserting item 64: " + (hashTable.insert(64) ? "Success" : "Failed"));
        System.out.println("Inserting item 99: " + (hashTable.insert(99) ? "Success" : "Failed"));
        System.out.println("Inserting item 42: " + (hashTable.insert(42) ? "Success" : "Failed"));
        System.out.println("Inserting item 49: " + (hashTable.insert(49) ? "Success" : "Failed"));
        System.out.println("Inserting item 48: " + (hashTable.insert(48) ? "Success" : "Failed"));
        System.out.println("Inserting item 21: " + (hashTable.insert(21) ? "Success" : "Failed"));

        hashTable.displayContents();

        System.out.println("Removing item 32: " + (hashTable.remove(32) ? "Success" : "Failed"));
        System.out.println("Removing item 11: " + (hashTable.remove(11) ? "Success" : "Failed"));

        System.out.println("Searching for item 64: " + (hashTable.search(64) != -1 ? "Found" : "Not Found"));
        System.out.println("Inserting item 9: " + (hashTable.insert(9) ? "Success" : "Failed"));
        System.out.println("Searching for item 48: " + (hashTable.search(48) != -1 ? "Found" : "Not Found"));
        System.out.println("Searching for item 32: " + (hashTable.search(32) != -1 ? "Found" : "Not Found"));

        System.out.println("Removing item 64: " + (hashTable.remove(64) ? "Success" : "Failed"));
        System.out.println("Removing item 99: " + (hashTable.remove(99) ? "Success" : "Failed"));

        hashTable.displayContents();
    }
}
