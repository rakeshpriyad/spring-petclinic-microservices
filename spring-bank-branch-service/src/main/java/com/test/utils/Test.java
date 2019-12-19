package com.test.utils;

import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        final String danglingChars = "+*?^";
        String token= "+";
        String toSplit= "+C-BSRITC";

        String arr[] = danglingChars.contains(token)? toSplit.replaceFirst("^"+Pattern.quote(token), "").split(Pattern.quote(token)): toSplit.replaceFirst("^"+token, "").split(token);
        for(String s: arr){
            System.out.println(s);
        }


        /*Pattern p = Pattern.compile(String.valueOf("//"+token));
        String arr2[] = p.split(toSplit);
        for(String s: arr2){
            System.out.println(s);
        }*/
    }
}
