import java.io.*;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
  static int indent;
  static boolean valid, validate, compact, prettyprint, replaceprettyprint, replacecompact;
  static String jsonstring, filepath;
  static ArrayList<String> output;

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      System.out.println("Give file path and other feautures in command line arguments");
      return;
    }
    filepath = args[0];
    for (String str : args) {
      if (str.equals("validate")) validate = true;
      if (str.equals("compact")) compact = true;
      if (str.equals("prettyprint")) prettyprint = true;
      if (str.equals("replaceprettyprint")) replaceprettyprint = true;
      if (str.equals("replacecompact")) replacecompact = true;
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
