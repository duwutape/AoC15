package day21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day21 {
    public static void main(String[] args){
        new Day21();
    }

    public Day21() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day21/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
