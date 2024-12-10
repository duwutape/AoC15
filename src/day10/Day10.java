package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        File input = new File("src/day10/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
