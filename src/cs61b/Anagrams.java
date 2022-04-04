package cs61b;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        if(strs.length == 1){
            temp.add(strs[0]);
            ans.add(temp);
            return ans;
        }
        search(ans, temp, result, strs);
        return ans;
    }

    public static String Stringsort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String data = new String(arr); //char->String
        return data;
    }

    public void search(List<List<String>> ans, List<String> temp, List<String> result, String[] strs){
        for(int i = 0; i < strs.length; i++){
            result.add(strs[i]);
        }
        while(result.size() > 0){
            int k = 1;
            temp.add(result.get(0));
            for(k = 1; k < result.size(); k++){
                if(Stringsort(result.get(0)).equals(Stringsort(result.get(k)))){
                    temp.add(result.get(k));
                    result.remove(k);
                    k--;
                }
            }
            result.remove(0);
            ans.add(temp);
            temp = new ArrayList<String>();
        }
    }
}
