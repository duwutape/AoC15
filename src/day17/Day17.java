package day17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day17 {
    public static void main(String[] args) {
        new Day17();
    }

    public Day17() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day17/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
