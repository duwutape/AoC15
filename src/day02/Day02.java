package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day02 {

    public Day02() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File file = new File("src/day02/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<int[]> allDimensions = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] dimentionsString = line.split("x");
            int[] dimensions = {Integer.parseInt(dimentionsString[0]), Integer.parseInt(dimentionsString[1]), Integer.parseInt(dimentionsString[2])};
            allDimensions.add(dimensions);
        }

        calc(allDimensions);
    }

    private void calc(ArrayList<int[]> data) {
        int wraping = 0;
        int ribbon = 0;


        for (int[] dim : data) {
            Arrays.sort(dim);

            int side1 = dim[0] * dim[1];
            int side2 = dim[1] * dim[2];
            int side3 = dim[0] * dim[2];

            wraping += 2 * side1 + 2 * side2 + 2 * side3 + side1;

            ribbon += 2 * dim[0] + 2 * dim[1] + dim[0] * dim[1] * dim[2];
        }

        System.out.println(wraping);
        System.out.println(ribbon);
    }
}
