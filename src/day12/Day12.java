package day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        File input = new File("src/day12/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
