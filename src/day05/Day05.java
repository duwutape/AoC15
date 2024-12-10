package day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day05 {
    public static void main(String[] args) {
        new Day05();
    }

    public Day05() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File file = new File("src/day05/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> words = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            words.add(line);
        }

        int countNice1 = 0;
        int countNice2 = 0;

        for (String word : words) {
            if (checkNice1(word)) {
                countNice1++;
            }
            if (checkNice2(word)) {
                countNice2++;
            }
        }
        System.out.println(countNice1);
        System.out.println(countNice2);
    }

    private boolean checkNice1(String word) {
        return checkDisallowed(word) && checkVowels(word) && checkDoubles(word);
    }

    private boolean checkVowels(String word) {
        return word.matches("[a-z&&[^aeiou]]*[aeiou][a-z&&[^aeiou]]*[aeiou][a-z&&[^aeiou]]*[aeiou][a-z]*");
    }

    private boolean checkDoubles(String word) {
        return word.matches("[a-z]*([a-z])\\1+[a-z]*");
    }

    private boolean checkDisallowed(String word) {
        return !word.matches("([a-z]*(ab|cd|pq|xy)[a-z]*)");
    }

    private boolean checkNice2(String word) {
        return checkPairs(word) && checkXYX(word);
    }

    private boolean checkPairs(String word) {
        return word.matches("[a-z]*([a-z]{2})[a-z]*\\1[a-z]*");
    }

    private boolean checkXYX(String word) {
        return word.matches("[a-z]*([a-z])[a-z]\\1[a-z]*");
    }
}
