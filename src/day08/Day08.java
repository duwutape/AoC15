package day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day08 {
    public static void main(String[] args) {
        new Day08();
    }

    public Day08() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day08/input.txt");
        Scanner scanner = new Scanner(input);

        int charsPt1 = 0;
        int memoryPt1 = 0;
        int charsPt2 = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String linePt1 = line;

            charsPt1 += linePt1.length();

            linePt1 = linePt1.replaceAll("\\\\{2}", "!");
            linePt1 = linePt1.replaceAll("\\\\\"", "?");
            linePt1 = linePt1.replaceAll("\\\\x..", "§");
            linePt1 = linePt1.replaceAll("\"", "");

            memoryPt1 += linePt1.length();


            String linePt2 = line;
            linePt2 = linePt2.replaceAll("\\\\","!!");
            linePt2 = linePt2.replaceAll("\"","??");
            charsPt2 += linePt2.length()+2;

        }

        int memoryPt2 = charsPt1;

        int res1 = charsPt1 - memoryPt1;
        int res2= charsPt2 - memoryPt2;

        System.out.println("res pt. 1: " + res1);
        System.out.println("res pt. 2: " + res2);
    }
}
