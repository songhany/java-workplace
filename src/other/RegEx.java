package other;

import java.util.regex.Pattern;

public class RegEx {

    public static void main (String[] args) {
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        String email = "songhan@gmail.com";

        System.out.println(pattern.matcher(email).matches());
    }
}
