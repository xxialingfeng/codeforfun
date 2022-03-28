package cs61b;

import java.util.ArrayList;

public class Palindrome implements CharacterComparator {
    public static Deque<Character> wordToDeque(String word){
        Deque<Character> combinations = new ArrayListDeque<>();
        char[] str = word.toCharArray();
        int letter = str.length;
        for(int i = 0; i < letter; i ++){
            combinations.addLast(str[i]);
        }
        return combinations;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if( x == y){
            return true;
        }
        return false;
    }

    public static boolean isPalindrome2(String word){
        if(word.length() % 2 == 0 && word.length() == 0){
            return true;
        }
        else if(word.length() % 2 != 0 && word.length() == 1) {
            return true;
        }
        Deque<Character> help = new ArrayListDeque<>();
        char[] str = word.toCharArray();
        for(int i = 0; i < str.length; i ++){
            help.addLast(str[i]);
        }
        int m;
        int n = help.size()-1;
        for(m = 0; m < n-1; ){
            for(n = help.size() - 1; n > m;){
                if(help.removeFirst() == help.removeLast()){
                    isPalindrome(word.substring(m++,n--));
                }
            }
        }
        return true;
    }
    //另一种方法
    //    public boolean isPalindrome(String word) {
    //        Deque<Character> wordDeque = wordToDeque(word);
    //        while (wordDeque.size() > 1) {
    //            char first = wordDeque.removeFirst();
    //            char last = wordDeque.removeLast();
    //            if (first != last) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }
    //好牛逼的方法
    private static boolean isPalindrome(Deque<Character> wordInDeque) {
        while (wordInDeque.size() > 1) {
            return wordInDeque.removeFirst() == wordInDeque.removeLast() && isPalindrome(wordInDeque);
        }
        return true;
    }

    public static boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> wordDeque = wordToDeque(word);
        while (wordDeque.size() > 1){
            char first = wordDeque.removeFirst();
            char last = wordDeque.removeLast();
            if(!cc.equalChars(first, last)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome("baaab"));
        System.out.println(isPalindrome2("aaa"));
    }
}
