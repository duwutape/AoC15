package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
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

        File input_MFCSAM = new File("src/day16/MFCSAM.txt");
        Scanner scanner_MFCSAM = new Scanner(input_MFCSAM);

        HashMap<String, Integer> test = new HashMap<>();
        while (scanner_MFCSAM.hasNextLine()) {
            String line = scanner_MFCSAM.nextLine();
            String[] parts = line.split(": ");

            test.put(parts[0], Integer.parseInt(parts[1]));
        }


        ArrayList<HashMap<String, Integer>> aunts = new ArrayList<>();

        while (scanner.hasNextLine()) {
            HashMap<String, Integer> aunt = new HashMap<>();
            String line = scanner.nextLine();
            String[] parts = line.split(":", 2);
            String[] name = parts[0].split(" ");

            aunt.put(name[0], Integer.parseInt(name[1]));

            String[] data = parts[1].split(",");

            for (String singleData : data) {
                String[] dataSplit = singleData.split(": ");
                aunt.put(dataSplit[0].trim(), Integer.parseInt(dataSplit[1]));
            }
            aunts.add(aunt);
        }


        for (HashMap<String, Integer> aunt : aunts) {
            boolean eq = true;
            for (String key : aunt.keySet()) {
                if (test.containsKey(key)) {
                    if (!(Objects.equals(test.get(key), aunt.get(key)))) {
                        eq = false;
                        break;
                    }
                }
            }
            if (eq) {
                System.out.println("Part 1: " + aunt.get("Sue"));
            }
        }

        for (HashMap<String, Integer> aunt : aunts) {
            boolean eq = true;
            for (String key : aunt.keySet()) {
                if (test.containsKey(key)) {
                    if (Objects.equals(key, "cats") || Objects.equals(key, "trees")) {
                        if ((test.get(key) >= aunt.get(key))) {
                            eq = false;
                            break;
                        }
                    } else if (Objects.equals(key, "pomeranians") || Objects.equals(key, "goldfish")) {
                        if ((test.get(key) <= aunt.get(key))) {
                            eq = false;
                            break;
                        }
                    } else {
                        if (!(Objects.equals(test.get(key), aunt.get(key)))) {
                            eq = false;
                            break;
                        }
                    }
                }
            }
            if (eq) {
                System.out.println("Part 2: " + aunt.get("Sue"));
            }
        }
    }
}
