import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFormatter {
  static int indent;
  static boolean valid, validate, compact, prettyprint, replaceprettyprint, replacecompact;
  static String jsonstring, filepath;
  static ArrayList<String> output;

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      System.out.println("Give file path and other feautures in command line arguments");
      return;
    }
    for (String str : args) {
      if (str.contains("--from-")) filepath = str.substring(7, str.length());
      if (str.contains("--indent-")) {
        indent = Integer.parseInt(str.substring(9, str.length()));
        System.out.println(filepath);
      }
      if (str.equals("--validate")) validate = true;
      if (str.equals("--compact-output")) compact = true;
      if (str.equals("--tab")) indent = 1;
      if (str.equals("--prettyprint")) prettyprint = true;
      if (str.equals("--replace")) replaceprettyprint = true;
      if (str.equals("--replacecompact")) replacecompact = true;
      if (isIndent(str)) indent = Integer.parseInt(str);
    }
    try {
      Object obj = new JSONParser().parse(new FileReader(filepath));
      JSONObject jo = (JSONObject) obj;
      jsonstring = jo.toString();
    } catch (FileNotFoundException e) {
      System.out.println("file does not exists in given path");
      return;
    } catch (Exception f) {
      System.out.println("Not A Valid JSON File");
      return;
    }
    output = new JsonToString(indent).prettyJSON(jsonstring);
    if (validate) System.out.println("The given file is Valid" + "\n");
    if (compact) {
      System.out.println("Compact format of json file is : ");
      printcompact(jsonstring);
    }
    if (prettyprint) {
      System.out.println("PrettyPrint format of json file is : ");
      printprettyprint(output);
    }
    if (replacecompact) replacewithcompact(jsonstring);
    if (replaceprettyprint) replacewithprettyprint(output);
  }

  public static boolean isIndent(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static void printcompact(String jsonstring) {
    System.out.println(jsonstring + "\n");
  }

  public static void printprettyprint(ArrayList<String> output) {
    for (String s : output) System.out.println(s);
  }

  public static void replacewithcompact(String jsonstring) throws IOException {
    FileWriter fw = new FileWriter(filepath);
    fw.write(jsonstring);
    fw.close();
  }

  public static void replacewithprettyprint(ArrayList<String> output) throws IOException {
    FileWriter fw = new FileWriter(filepath);
    for (String s : output) fw.write(s + "\n");
    fw.close();
  }
}

class JsonToString {
  static int indent;

  JsonToString(int x) {
    indent = x;
  }

  public ArrayList<String> prettyJSON(String s) {
    int prefix = 0;
    String[] arr = s.split(",");
    ArrayList<String> ans = new ArrayList<String>();

    for (int i = 0; i < arr.length; i++) {
      String str;
      if (i <= arr.length - 1) str = arr[i] + ",";
      else str = arr[i];
      prefix = generate(str, ans, prefix);
    }
    String last = ans.get(ans.size() - 1);
    if (last.equals("},")) ans.set(ans.size() - 1, "}");
    if (last.equals("],")) ans.set(ans.size() - 1, "]");
    return ans;
  }

  public static int generate(String s, ArrayList<String> ans, int prefix) {
    String temp = "";
    temp = make(prefix) + temp;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '}' || c == ']') {
        if (!temp.equals(make(prefix))) ans.add(temp);
        prefix--;
        if (c == '}') ans.add(make(prefix) + "}");
        else ans.add(make(prefix) + "]");
        prefix = generate(s.substring(i + 1, s.length()), ans, prefix);
        return prefix;
      }
      if (c == '{' || c == '[') {
        if (!temp.equals(make(prefix))) ans.add(temp);
        if (c == '{') ans.add(make(prefix) + "{");
        else ans.add(make(prefix) + "[");
        prefix++;
        prefix = generate(s.substring(i + 1, s.length()), ans, prefix);
        return prefix;
      }
      temp = temp + c;
    }
    if (temp.equals(make(prefix) + ",")) {
      ans.set(ans.size() - 1, ans.get(ans.size() - 1) + ",");
    } else ans.add(temp);
    return prefix;
  }

  public static String make(int x) {
    String s = generateindent(x);
    String str = "";
    for (int i = 0; i < indent; i++) str = str + s;
    return str;
  }

  public static String generateindent(int x) {
    String s = "";
    for (int i = 0; i < x; i++) s = "\t" + s;
    return s;
  }
}
