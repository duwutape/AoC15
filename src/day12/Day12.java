package day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day12 {
    public static void main(String[] args) {
        new Day12();
    }

    public Day12() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day12/input.json");
        Scanner scanner = new Scanner(input);

        int sumPt1 = 0;
        int sumPt2 = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Pattern pattern = Pattern.compile("-?[0-9]+");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                sumPt1 += Integer.parseInt(matcher.group());
            }

            //String line2 = line.replaceAll("\\{.[^{]*\\\"red\\\".[^}]*\\}", "");
            String line2 = line;
            char[] chars = line2.toCharArray();

            Object parsed = parseJson(line2);
            Object cleaned = removeObjectsWithValue(parsed, "red");
            Matcher matcher1 = pattern.matcher(toJson(cleaned));


            while (matcher1.find()) {
                sumPt2 += Integer.parseInt(matcher1.group());
            }

        }
        System.out.println(sumPt1);
        System.out.println(sumPt2);
    }

    public static Object parseJson(String json) {
        return new Parser(json).parse();
    }

    public static Object removeObjectsWithValue(Object json, String target) {
        if (json instanceof Map) {
            Map<String, Object> obj = (Map<String, Object>) json;

            // If any field equals the target → delete this whole object
            for (Object v : obj.values()) {
                if (Objects.equals(String.valueOf(v), target)) {
                    return null;
                }
            }

            // Otherwise recursively clean
            Map<String, Object> result = new LinkedHashMap<>();
            for (Map.Entry<String, Object> e : obj.entrySet()) {
                Object cleaned = removeObjectsWithValue(e.getValue(), target);
                if (cleaned != null)
                    result.put(e.getKey(), cleaned);
            }
            return result;
        }

        if (json instanceof List) {
            List<Object> arr = (List<Object>) json;
            List<Object> result = new ArrayList<>();

            for (Object item : arr) {
                Object cleaned = removeObjectsWithValue(item, target);
                if (cleaned != null)
                    result.add(cleaned);
            }
            return result;
        }

        return json; // primitive
    }

    public static String toJson(Object obj) {
        if (obj == null) return "null";

        if (obj instanceof Map) {
            StringBuilder sb = new StringBuilder("{");
            boolean first = true;
            for (var e : ((Map<String, Object>) obj).entrySet()) {
                if (!first) sb.append(",");
                first = false;
                sb.append("\"").append(e.getKey()).append("\":").append(toJson(e.getValue()));
            }
            return sb.append("}").toString();
        }

        if (obj instanceof List) {
            StringBuilder sb = new StringBuilder("[");
            boolean first = true;
            for (Object v : (List<Object>) obj) {
                if (!first) sb.append(",");
                first = false;
                sb.append(toJson(v));
            }
            return sb.append("]").toString();
        }

        if (obj instanceof String) {
            return "\"" + obj + "\"";
        }

        return String.valueOf(obj);
    }
}
