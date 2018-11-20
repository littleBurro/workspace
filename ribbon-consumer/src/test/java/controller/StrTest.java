package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrTest {
    public static void main(String[] args){
        String str = "ASSERT_TYPE_CODE";
        str = str.toLowerCase();
        final StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("_(\\w)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}
