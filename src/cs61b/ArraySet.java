package cs61b;

import javafx.scene.effect.Glow;

import java.util.*;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T>{
        private int ptr;
        public boolean hasNext(){
            return (ptr != size);
        }

        public T next(){
            T returnItem = items[ptr];
            ptr += 1;
            return returnItem;
        }
    }

    public ArraySet(){
       items = (T[]) new Object[100];
       size = 0;
    }
    public boolean contains(T x){
        for(int i =0; i < size; i+=1){
            if(items[i] == null){
                if(x == null){
                    return true;
                }
            }
            if(items[i].equals(x)){ //important!如果用==，那么就会比较地址是否相同
                return true;
            }
        }
        return false;
    }

    public void add(T x){
        if(x == null){
            return;
        }
        if(contains(x)){
            return;
        }
        items[size] = x;
        size += 1;
        }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        String returnString = "{";
        for(int i = 0; i < size; i ++){
            returnString += items[i].toString();
            returnString += ",";
        }
        returnString += "}";
        return returnString;
    }
    //warning: this code is slow. Intuition: adding even a single character to a
    //String creates an entirely new string,

    public String ToString(){
        StringBuilder returnSB = new StringBuilder("{");
        for(int i = 0; i < size-1; i ++){
            returnSB.append(items[i].toString());
            returnSB.append(",");
        }
        returnSB.append("}");
        return returnSB.toString();
    }

    public String ToString2(){
        List<String> ListOfItems = new ArrayList<>();
        for(T x: this){
            ListOfItems.add(x.toString());
        }
        return "{" + String.join(",", ListOfItems) + "}";
    }

    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff){
        ArraySet<Glerp> returnSet = new ArraySet<Glerp>();
        for(Glerp x : stuff){
            returnSet.add(x);
        }
        return returnSet;
    }

    @Override
    public boolean equals(Object other){//use object to allow generics
        if(other == null){
            return false;
        }
        if(this == other){
            return true;
        }
        if(other.getClass() != this.getClass()){
            return false;
        }//getClass https://www.runoob.com/java/java-object-getclass.html
        ArraySet<T> o = (ArraySet<T>) other;
        if(this.size() != o.size()){
            return false;
        }

        /*
        for(int i = 0; i < this.size-1; i ++){
            if(!o.contains(items[i])){
                return false;
            }
        }*/
        for(T item : this){
            if(!o.contains(item)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        ArraySet<String> s = new ArraySet<>();//generic type variables, and actual type arguments
        Set<String> s2 = new HashSet<>();

        Iterator<String> seer = s.iterator();
        while(seer.hasNext()){
            System.out.println(seer.next());
        }

        ArraySet<String> set = ArraySet.of("hi", "iam", "here"); //为什么？？
        System.out.println(set);

        Set<String> str1 = Set.of("a","c","b");
        System.out.println(str1);

    }
}
