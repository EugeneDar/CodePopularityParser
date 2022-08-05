import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, Long> amountMap = new HashMap<>();

    public static void correctedAddToMap(String name, long amount) {
        if (!amountMap.containsKey(name)) {
            amountMap.put(name, amount);
        } else {
            long currAmount = amountMap.get(name);
            amountMap.put(name, currAmount + amount);
        }
    }

    public static void addToMap(String name, long amount) {
        switch (name) {
            case /*"[]",*/ ".charAt" -> correctedAddToMap("char-at", amount);
            case "strcmp", "<=>", "casecmp", "compareTo" -> correctedAddToMap("compare", amount);
            case ".concat", "concat" -> correctedAddToMap("concatenate", amount);
            case ".endsWith", ".endswith", "end_with?" -> correctedAddToMap("ends-with", amount);
            case "sprintf", ".format", "format" -> correctedAddToMap("format", amount);
            case "isalpha", ".isalpha" -> correctedAddToMap("is-alphabetic", amount);
            case "isdigit", ".isdigit" -> correctedAddToMap("is-int", amount);
            case "isxdigit", ".isHexDigit" -> correctedAddToMap("is-hexadecimal", amount);
            case ".isLowerCase", ".islower" -> correctedAddToMap("is-lowercase", amount);
            case ".isUpperCase", ".isupper" -> correctedAddToMap("is-uppercase", amount);
            case ".isBlank", ".isspace" -> correctedAddToMap("is-whitespace", amount);
            case ".join" -> correctedAddToMap("join", amount);
            case ".matches", "re.match", "match?" -> correctedAddToMap("matches-regexp", amount);
            case ".partition", "partition" -> correctedAddToMap("partition", amount);
            case ".repeat" -> correctedAddToMap("repeat", amount);
            case ".replace", ".replaceAll", "replace" -> correctedAddToMap("replace-all", amount);
            case ".split", "split" -> correctedAddToMap("split", amount);
            case "startsWith", ".startswith", "start_with?" -> correctedAddToMap("starts-with", amount);
            case ".strip", "strip" -> correctedAddToMap("strip", amount);
            case ".substr", "substring", ".slices", "slice" -> correctedAddToMap("substring", amount);
            case ".swapcase", "swapcase" -> correctedAddToMap("swap-case", amount);
            case "stof", "to_f" -> correctedAddToMap("to-float", amount);
            case "stoi", "valueOf", "to_i" -> correctedAddToMap("to-int", amount);
            case "tolower", ".toLowerCase", ".lower", "downcase" -> correctedAddToMap("to-lowercase", amount);
            case "toupper", ".toUpperCase", ".upper", "upcase" -> correctedAddToMap("to-uppercase", amount);
            case ".stripLeading", ".lstrip", "lstrip" -> correctedAddToMap("trim-left", amount);
            case ".stripTrailing", ".rstrip", "rstrip" -> correctedAddToMap("trim-right", amount);
        }
    }

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("results.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] strings = line.split(" ");
                addToMap(strings[0], Long.parseLong(strings[1]));
                line = reader.readLine();
            }
            fr.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        long allAmount = 0;

        for (Map.Entry<String, Long> entry : amountMap.entrySet()) {
            allAmount += entry.getValue();
        }

        for (Map.Entry<String, Long> entry : amountMap.entrySet()) {
            double percentage = ((double) entry.getValue() * 100.0) / ((double) allAmount);
            System.out.println(entry.getKey() + " : " + percentage);
        }
    }
}

///////////////////////////////////////////////////////////////////////
// capitalize     //
// char-at        // ok
// compare        // ok
// concatenate    // ok
// contains       //
// ends-with      // ok
// equals         //
// find-first     //
// find-last      //
// format         // ok
// hash           //
// insert         //
// is-alphabetic  // ok
// is-empty       //
// is-hexadecimal // ok
// is-int         // ok
// is-lowercase   // ok
// is-uppercase   // ok
// is-whitespace  // ok
// join           // ok
// length         //
// matches-regexp // ok
// partition      // ok
// repeat         // ok
// replace-all    // ok
// split          // ok
// starts-with    // ok
// strip          // ok
// substring      // ok
// swap-case      // ok
// to-float       // ok
// to-int         // ok
// to-lowercase   // ok
// to-uppercase   //
// trim-left      //
// trim-right     //