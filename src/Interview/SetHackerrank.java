package Interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class SetHackerrank {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        //Write your c ode here
        Set<String> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < t; i++) {
            String name = pair_left[i] + pair_right[i];
            boolean addSuccess = set.add(name);
            if (addSuccess) {
                cnt++;
                System.out.println(cnt);
            } else {
                System.out.println(cnt);
            }
        }
    }
}
