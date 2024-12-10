package day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day08 {
    public static void main(String[] args) {
        new Day08();
    }

    public Day08() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day08/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
