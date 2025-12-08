package day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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

        HashMap<String, Integer> happiness = new HashMap<>();
        ArrayList<String> guests = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replaceAll("\\.", "");
            String[] parts = line.split(" ");

            if (!guests.contains(parts[0])) {
                guests.add(parts[0]);
            }

            if (line.contains("gain")) {
                happiness.put(parts[0] + "-" + parts[parts.length - 1], Integer.parseInt(parts[3]));
            } else {
                happiness.put(parts[0] + "-" + parts[parts.length - 1], -Integer.parseInt(parts[3]));
            }
        }

        for (String guest : guests) {
            happiness.put(guest + "-me", 0);
            happiness.put("me-" + guest, 0);
        }

        ArrayList<ArrayList<String>> permutationsPt1 = generatePerm(guests);
        guests.add("me");
        ArrayList<ArrayList<String>> permutationsPt2 = generatePerm(guests);

        System.out.println(calcHappiness(permutationsPt1, happiness));
        System.out.println(calcHappiness(permutationsPt2, happiness));
    }

    private ArrayList<ArrayList<String>> generatePerm(ArrayList<String> original) {
        ArrayList<String> copy = new ArrayList<>(original);
        if (copy.isEmpty()) {
            ArrayList<ArrayList<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        String firstElement = copy.removeFirst();
        ArrayList<ArrayList<String>> returnValue = new ArrayList<>();
        ArrayList<ArrayList<String>> permutations = generatePerm(copy);
        for (ArrayList<String> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                ArrayList<String> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }

    private int calcHappiness(ArrayList<ArrayList<String>> permutations, HashMap<String, Integer> happiness) {
        int max_happy = 0;
        for (ArrayList<String> permutation : permutations) {
            int happy = 0;
            for (int i = 0; i < permutation.size(); i++) {
                String key;
                String key_rev;

                if (i < permutation.size() - 1) {
                    key = permutation.get(i) + "-" + permutation.get(i + 1);
                    key_rev = permutation.get(i + 1) + "-" + permutation.get(i);
                } else {
                    key = permutation.get(i) + "-" + permutation.getFirst();
                    key_rev = permutation.getFirst() + "-" + permutation.get(i);
                }

                happy += happiness.get(key) + happiness.get(key_rev);
            }
            if (max_happy == 0 || max_happy < happy) {
                max_happy = happy;
            }
        }
        return max_happy;
    }
}
