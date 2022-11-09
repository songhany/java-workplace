package laiCode.hashMap;

import java.util.*;

public class HashUsing {

    public static void main(String[] args) {
        Map<String, Integer> employerNumbers = new HashMap<>();
        employerNumbers.put("yahoo", 1);      // add key-value pair, return null
        System.out.println(employerNumbers);  // {yahoo : 1}

        employerNumbers.put("google", 2);
        System.out.println(employerNumbers);  // {yahoo=1, google=2}
        Integer yc = employerNumbers.get("yahoo");  // yc = 1
        System.out.println(yc);  // 1, yc is the previous value for key "yahoo"

        yc = employerNumbers.put("yahoo", 5);  // update key-value, return old value
        System.out.println(yc);  // 1, returned old value

        Integer fGet = employerNumbers.get("facebook");  // fGet = null
        System.out.println(fGet);  // null
        boolean fContainsKey = employerNumbers.containsKey("facebook");
        System.out.println(fContainsKey);  // false
        Integer fRemove = employerNumbers.remove("facebook");
        System.out.println(fRemove);  // null

        Integer gRemove = employerNumbers.remove("google");
        System.out.println(gRemove);  // 2, returned old value

        System.out.println(employerNumbers);  // {yahoo=5}
    }
}
