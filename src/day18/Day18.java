package day18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day18 {
    public static void main(String[] args) {
        new Day18();
    }

    public Day18() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day18/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
