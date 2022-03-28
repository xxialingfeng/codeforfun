package cs61b;

import java.util.*;

public class subset implements List {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }



    public static List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<String>();
        List<List<String>> ans = new ArrayList<List<String>>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        dfs(ans, temp, 0, arr, used);
        return ans;
        }

    public static List<List<String>> partition_two(String s) {
        List<String> temp = new ArrayList<String>();
        List<List<String>> ans = new ArrayList<List<String>>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        boolean used = false;
        backtrack(ans, temp, 0, arr, used);
        return ans;
    }

    public static void dfs(List<List<String>> ans, List<String> temp, int start, char[] arr, boolean[] used){
            if(start == arr.length){
                ans.add(new ArrayList<String>(temp));
                return;
            }

            for(int i = 0; i < arr.length; i++){
                if (used[i] || (i > 0 && !used[i - 1] && arr[i - 1] == arr[i])) { //这里用两个等号合适吗？
                    continue;
                }
                used[i] = true;
                temp.add(String.valueOf(arr[i])); //char->String
                dfs(ans, temp, start + 1, arr, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    public static void backtrack(List<List<String>> ans, List<String> temp, int start, char[] arr, boolean used){
        if(start == arr.length) {
            ans.add(new ArrayList<String>(temp));
            return;
        }
        backtrack(ans, temp, start+1, arr, false);
        if (!used && start > 0 && arr[start - 1] == arr[start]){ //这里用两个等号合适吗？
                return;
            }

         temp.add(String.valueOf(arr[start])); //char->String
         backtrack(ans, temp, start + 1, arr, true);
         temp.remove(temp.size() - 1);
        }


    public static void main(String[] args){
        char[] arr = new char[]{'a','b','c'};
        List<String> temp = new ArrayList<String>();
        temp.add(String.valueOf(arr[0]));
        System.out.println(temp);
        System.out.println(partition("aab"));
        System.out.println(partition_two("aab"));

    }
}
