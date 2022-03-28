package cs61b;

import java.util.Map;
import java.util.TreeMap;

public class map {
    public Map<String, Integer> mapping() {
        Map<String, Integer> m = new TreeMap<>();
        String[] text = {"sumomo", "mo", "momo", "mo", "momo", "no", "uchi"};
        for (String s : text) {
            int currentcount = m.getOrDefault(s, 0);
            m.put(s, currentcount + 1);
        }
        return m;
    }
}
