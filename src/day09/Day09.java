package day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day09 {
    public static void main(String[] args) {
        new Day09();
    }

    public Day09() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day09/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
