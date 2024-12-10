package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day14 {
    public static void main(String[] args) {
        new Day14();
    }

    public Day14() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day14/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
