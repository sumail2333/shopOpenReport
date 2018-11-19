package com.dxc.openShopReport.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public static boolean isHttpUrl(String urls) {
       if(urls.indexOf("http://")!=-1 ||urls.indexOf("https://")!=-1){
           return true;
       }else{
           return false;
       }
    }
}
