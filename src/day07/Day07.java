package day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day07 {
    public static void main(String[] args) {
        new Day07();
    }

    public Day07() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day07/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
