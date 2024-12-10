package day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day11 {
    public static void main(String[] args) {
        new Day11();
    }

    public Day11() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day11/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
