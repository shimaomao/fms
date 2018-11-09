package cn.com.leadu.fms.code.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TFMakeName {
	 private static Pattern linePattern = Pattern.compile("_(\\w)");  
     /**下划线转驼峰*/  
     public static String lineToHump(String str){  
         str = str.toLowerCase();  
         Matcher matcher = linePattern.matcher(str);  
         System.out.println("matcher:"+matcher);
         StringBuffer sb = new StringBuffer();  
         while(matcher.find()){  
             matcher.appendReplacement(sb, matcher.group(1).toUpperCase());  
         }  
         matcher.appendTail(sb);
         String upperCase = sb.substring(0, 1).toUpperCase();
         return upperCase+sb.substring(1,sb.length());  
     }  
     /**驼峰转下划线(�??单写法，效率低于{@link #humpToLine2(String)})*/  
     public static String humpToLine(String str){  
         return str.replaceAll("[A-Z]", "_$0").toLowerCase();  
     }  
     private static Pattern humpPattern = Pattern.compile("[A-Z]");  
     /**驼峰转下划线,效率比上面高*/  
     public static String humpToLine2(String str){  
         Matcher matcher = humpPattern.matcher(str);  
         StringBuffer sb = new StringBuffer();  
         while(matcher.find()){  
             matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());  
         }  
         matcher.appendTail(sb);  
         return sb.toString();  
     }  
     //�? �?个英文的第一个字转成小写
     public static String tofristlower(String string) {
    	 String upperCase = string.substring(0, 1).toLowerCase();
         return upperCase+string.substring(1,string.length());
     }
     public static void main(String[] args) {  
         String lineToHump = lineToHump("APPL_BIZ_INFO");  
         System.out.println(lineToHump);//fParentNoLeader  
         System.out.println(humpToLine(lineToHump));//f_parent_no_leader  
         System.out.println(humpToLine2(lineToHump));//f_parent_no_leader  
     }
}
