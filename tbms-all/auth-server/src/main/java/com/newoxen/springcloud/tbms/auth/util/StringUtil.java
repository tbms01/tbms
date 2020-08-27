package com.newoxen.springcloud.tbms.auth.util;

import org.bouncycastle.util.encoders.Base64;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static String getFirstWord(String sentence){
        if(sentence == null || "".equals(sentence.trim())){
            return "";
        }
        return sentence.trim().split(" ")[0];
    }

    /**
     * @param str
     * @return
     */
    public static String decode(final String str) {
        byte[] bytes = str.getBytes();
        return new String(Base64.decode(bytes));
    }

    public static boolean isNullOrSpace(final String str) {
        if(str == null || "".equals(str.trim())) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * 二进制数据编码为BASE64字符串
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static String encode(final String str) {
        byte[] bytes = str.getBytes();
        return new String(Base64.encode(bytes));
    }

    /**
     * @param str 匹配类规则的字符串
     * @param patternString 生成匹配模式的正则表达式
     * @param targetStr 目标字符串
     * @return
     */
    public static String replace(String str,String patternString,String targetStr,int start,int end){
        int num = 0;
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        //两个方法：appendReplacement, appendTail
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            if(num >= start && num < end) {
                matcher.appendReplacement(sb, targetStr);
            }
            num++ ;
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    public static String replaceFirst(String str,String patternString,String targetStr){
        return replace(str,patternString,targetStr,0,1);
    }


    public static String replaceSpaceFormMoreToOne(String str){
        if(str == null){
            return "";
        }
        Pattern p = Pattern.compile("\\s+");
        Matcher m = p.matcher(str);
        String newStr = m.replaceAll(" ");
        return newStr;
    }


}
