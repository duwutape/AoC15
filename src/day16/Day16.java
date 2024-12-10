package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day16 {
    public static void main(String[] args) {
        new Day16();
    }

    public Day16() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day16/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
