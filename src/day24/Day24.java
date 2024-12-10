package day24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day24 {
    public static void main(String[] args) {
        new Day24();
    }

    public Day24() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day24/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
