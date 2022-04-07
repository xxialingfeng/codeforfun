package lab9;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MyTrieSet implements TrieSet61B {
    private Node root;

    private static class Node{
        private boolean isKey;
        Map<Character, Node> map; //用哈希map来实现

        private Node(boolean b){
            this.isKey = b;
            this.map = new HashMap<>();
        }
    }

    public MyTrieSet(){
        root = new Node(true);
    }
    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean contains(String key) {
        if(this.root == null){
            return false;
        }
        if(key == null){
            throw new IllegalArgumentException();
        }
        Node curr = find(key);
        return curr.isKey && curr != null;
    }

    @Override
    public void add(String key) {
        if(key == null || key.length() < 1){
            return;
        }
        Node curr = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(!curr.map.containsKey(c)){
                curr.map.put(c, new Node(false));
            }
            curr = curr.map.get(c);
        }
        curr.isKey = true;
    }

    private Node find(String key) { //当功能差不多时，构造一个新的函数直接调用会让代码显得不冗长
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                return null;
            }
            curr = curr.map.get(c);
        }
        return curr;
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        List<String> ans = new ArrayList<String>();
        Node n = find(prefix);
        colHelp(prefix, ans, n);
        return ans;
    }

    public void colHelp(String s, List<String> x, Node n){
        if(n == null){
            return;
        }
        if(n.isKey){
            x.add(s);
        }
        for(Character c : n.map.keySet()){
            colHelp(s + c, x, n.map.get(c));
        }
    }


    @Override
    public String longestPrefixOf(String key) {
        StringBuilder longestPrefix = new StringBuilder();
        Node curr = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(!curr.map.containsKey(c)){
                return longestPrefix.toString();
            }else{
                longestPrefix.append(c);
                curr = curr.map.get(c);
            }
        }
        return longestPrefix.toString();
    }


//     * Return the longest common prefix of the given key in the Trie.
//     */

    public String longestCommonPrefixOf(String key) {
        if (!contains(key)) {
            throw new IllegalArgumentException();
        }
        String longestCommonPrefix = "";
        String tempPrefix = "";
        Node currNode = root;
        for (int i = 0; i < key.length(); i += 1) {
            char c = key.charAt(i);
            if (currNode.map.keySet().size() > 1) {
                longestCommonPrefix = tempPrefix;
            }
            tempPrefix += c;
            currNode = currNode.map.get(c);
        }
        return longestCommonPrefix;
    }
}

