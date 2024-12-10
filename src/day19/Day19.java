package day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day19 {
    public static void main(String[] args) {
        new Day19();
    }

    public Day19() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day19/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
