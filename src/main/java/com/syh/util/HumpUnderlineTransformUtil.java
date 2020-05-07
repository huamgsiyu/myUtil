package com.syh.util;

import com.syh.constant.SymbolConstant;

/**
 * HumpUnderlineTransformUtil
 *  驼峰命名和下划线命名互转
 *
 * @author HSY
 * @since 2020/05/07 12:55
 */
public class HumpUnderlineTransformUtil {

    /**
     * 下划线命名转为驼峰命名
     * @param param 字符串
     * @return String
     */
    public static String underlineToHump(String param){
        if (!param.contains(SymbolConstant.UNDERLINE)) {
            return param;
        }
        StringBuilder result = new StringBuilder();
        String[] str = param.split(SymbolConstant.UNDERLINE);
        for(String s :str){
            // 第一个单词全小写
            if(result.length() == 0){
                result.append(s.toLowerCase());
            }else{
                // 第二个单词开始，首字母大写
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * 驼峰命名转为下划线命名
     * @param param 字符串
     * @return  String
     */
    public static String humpToUnderline(String param){
        StringBuilder sb = new StringBuilder(param);
        int temp = 0;
        if (!param.contains(SymbolConstant.UNDERLINE)) {
            for(int i = 0; i < param.length(); i++){
                if(Character.isUpperCase(param.charAt(i))){
                    sb.insert(i + temp, SymbolConstant.UNDERLINE);
                    temp += 1;
                }
            }
        }
        return sb.toString().toLowerCase();
    }
}
