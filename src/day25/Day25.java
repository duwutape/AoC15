package day25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day25 {
    public static void main(String[] args) {
        new Day25();
    }

    public Day25() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day25/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
