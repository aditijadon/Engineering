package Coding.array;

import java.util.Arrays;

public class ValidAnagram {
    static boolean isAnagram(String str1, String str2){
        str1 = str1.replaceAll("\\s","");
        str2 =  str2.replaceAll("\\s","");

        if(str1.length() != str2.length())
            return false;

        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b) ? true : false;
    }

    public static void main(String[] args) {
        String str1 = "racecar";
        String str2 = "carrace";
        System.out.println(isAnagram(str1, str2));
    }
}
