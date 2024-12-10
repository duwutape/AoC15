package day23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day23 {
    public static void main(String[] args) {
        new Day23();
    }

    public Day23() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day23/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
