package day12;

import java.util.*;

public class Parser {

    private final String s;
    private int pos = 0;

    Parser(String s) {
        this.s = s.trim();
    }

    Object parse() {
        skipWs();
        Object value = parseValue();
        skipWs();
        return value;
    }

    private Object parseValue() {
        skipWs();
        if (pos >= s.length()) throw new RuntimeException("Unexpected end");

        char c = s.charAt(pos);
        if (c == '{') return parseObject();
        if (c == '[') return parseArray();
        if (c == '"') return parseString();
        if (Character.isDigit(c) || c == '-') return parseNumber();

        if (s.startsWith("true", pos)) {
            pos += 4;
            return true;
        }
        if (s.startsWith("false", pos)) {
            pos += 5;
            return false;
        }
        if (s.startsWith("null", pos)) {
            pos += 4;
            return null;
        }

        throw new RuntimeException("Unexpected char: " + c);
    }

    private Map<String, Object> parseObject() {
        Map<String, Object> obj = new LinkedHashMap<>();
        expect('{');
        skipWs();

        if (peek() == '}') {
            pos++;
            return obj;
        }

        while (true) {
            skipWs();
            String key = parseString();
            skipWs();
            expect(':');
            skipWs();
            Object value = parseValue();
            obj.put(key, value);
            skipWs();

            char c = expect(',', '}');
            if (c == '}') break;
        }
        return obj;
    }

    private List<Object> parseArray() {
        List<Object> arr = new ArrayList<>();
        expect('[');
        skipWs();

        if (peek() == ']') {
            pos++;
            return arr;
        }

        while (true) {
            skipWs();
            arr.add(parseValue());
            skipWs();

            char c = expect(',', ']');
            if (c == ']') break;
        }
        return arr;
    }

    private String parseString() {
        expect('"');
        StringBuilder sb = new StringBuilder();

        while (pos < s.length()) {
            char c = s.charAt(pos++);
            if (c == '"') break;
            if (c == '\\') {
                char esc = s.charAt(pos++);
                switch (esc) {
                    case '"':
                        sb.append('"');
                        break;
                    case '\\':
                        sb.append('\\');
                        break;
                    case '/':
                        sb.append('/');
                        break;
                    case 'b':
                        sb.append('\b');
                        break;
                    case 'f':
                        sb.append('\f');
                        break;
                    case 'n':
                        sb.append('\n');
                        break;
                    case 'r':
                        sb.append('\r');
                        break;
                    case 't':
                        sb.append('\t');
                        break;
                    default:
                        throw new RuntimeException("Bad escape: \\" + esc);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private Number parseNumber() {
        int start = pos;
        while (pos < s.length() && "-0123456789.eE".indexOf(s.charAt(pos)) >= 0) pos++;
        String num = s.substring(start, pos);
        return num.contains(".") ? Double.parseDouble(num) : Long.parseLong(num);
    }

    private void skipWs() {
        while (pos < s.length() && Character.isWhitespace(s.charAt(pos))) pos++;
    }

    private char expect(char... expected) {
        char c = peek();
        for (char e : expected) {
            if (c == e) {
                pos++;
                return c;
            }
        }
        throw new RuntimeException("Expected " + Arrays.toString(expected) + " but found " + c);
    }

    private char peek() {
        return s.charAt(pos);
    }
}