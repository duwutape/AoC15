package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day06 {
    public static void main(String[] args) {
        new Day06();
    }

    public Day06() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day06/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
