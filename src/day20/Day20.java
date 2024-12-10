package day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day20 {
    public static void main(String[] args){
        new Day20();
    }

    public Day20() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day20/input.txt");
        Scanner scanner = new Scanner(input);
    }
}
