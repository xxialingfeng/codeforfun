package cs61b;


public class TrieSet {
    private static final int R = 128;
    private Node root;

    private static class Node{
        private char ch;
        private boolean isKey;
        private DataIndexedCharMap next; // if we use a DataIndexedCharMap to track
        // children, every mode has R links.
        //to better performance, not store the char
        private Node(char c, boolean b, int R){
            ch = c;
            isKey = b;
            next = new DataIndexedCharMap<Node>(R);
        }
    }
}
