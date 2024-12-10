package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day15 {
    public static void main(String[] args) {
        new Day15();
    }

    public Day15() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day15/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
