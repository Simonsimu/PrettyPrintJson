import java.util.ArrayList;

public class JsonToString {
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
