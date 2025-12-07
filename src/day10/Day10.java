package day10;

import java.io.FileNotFoundException;

public class Day10 {
    public static void main(String[] args) {
        new Day10();
    }

    public Day10() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {

        String str = "1113122113";
        for (int num = 0; num < 50; num++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char curChar = str.charAt(i);
                int count = 0;
                for (int j = i; j < str.length(); j++) {
                    if (str.charAt(j) == curChar) {
                        count++;
                        i++;
                    } else {
                        i = j - 1;
                        break;
                    }
                }
                sb.append(count).append(curChar);
            }
            str = sb.toString();
            if (num == 39) {
                System.out.println(str.length());
            }
        }
        System.out.println(str.length());
    }
}
