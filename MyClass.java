import java.util.*;
public class MyClass {
    
    static int prefix=0;
    public static void main(String args[]) {
        String s="{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
        //String s="{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}";
        //String s="[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
        String[] arr=s.split(",");
        ArrayList<String> ans=new ArrayList<String>();
        for(String str:arr)prefix=generate(str,ans,prefix);
        print(ans);
    }
    
    public static void print(ArrayList<String> ans){
        for(String ss:ans)System.out.println(ss);
    }
    
    public static int generate(String s,ArrayList<String> ans,int prefix){
        String temp="";
        temp=make(prefix)+temp;
        for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
           if(c=='}' || c==']'){
               ans.add(temp);
               prefix--;
               if(c=='}')ans.add(make(prefix)+"}");
               else ans.add(make(prefix)+"]");
               prefix=generate(s.substring(i+1,s.length()),ans,prefix);return prefix;
           }
           temp=temp+c;
           if(c=='{' || c=='['){
               ans.add(temp);
               prefix++;
               prefix=generate(s.substring(i+1,s.length()),ans,prefix);
               return prefix;
           }
        }
        ans.add(temp);
        return prefix;
    }
    
    public static String make(int x){
        String s="";
        for(int i=0;i<x;i++)s="\t"+s;
        return s;
    }
}
