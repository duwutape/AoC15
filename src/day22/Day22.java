package day22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day22 {
    public static void main(String[] args) {
        new Day22();
    }

    public Day22() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day22/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
