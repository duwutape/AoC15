package day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day13 {
    public static void main(String[] args) {
        new Day13();
    }

    public Day13() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day13/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
