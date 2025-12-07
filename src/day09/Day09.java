package day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day09 {
    public static void main(String[] args) {
        new Day09();
    }

    public Day09() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day09/input.txt");
        Scanner scanner = new Scanner(input);

        ArrayList<String> cities = new ArrayList<>();
        HashMap<String, Integer> routes = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] sublines = line.split(" = ");
            String[] lineCities = sublines[0].split(" to ");

            for (String city : lineCities) {
                if (!cities.contains(city)) {
                    cities.add(city);
                }
            }
            String key = lineCities[0] + "-" + lineCities[1];
            routes.put(key, Integer.parseInt(sublines[1]));
        }

        ArrayList<ArrayList<String>> allRoutes = generatePerm(cities);

        int minLen = 0;
        int maxLen = 0;

        for (ArrayList<String> list : allRoutes) {
            int len = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                String key = list.get(i) + "-" + list.get(i + 1);
                String key_rev = list.get(i + 1) + "-" + list.get(i);

                if (routes.containsKey(key)) {
                    len += routes.get(key);
                } else if (routes.containsKey(key_rev)) {
                    len += routes.get(key_rev);
                }
            }
            if (minLen == 0 || len < minLen) {
                minLen = len;
            }
            if (len > maxLen) {
                maxLen = len;
            }
        }

        System.out.println("min: " + minLen);
        System.out.println("max: " + maxLen);
    }

    private ArrayList<ArrayList<String>> generatePerm(ArrayList<String> original) {
        if (original.isEmpty()) {
            ArrayList<ArrayList<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        String firstElement = original.removeFirst();
        ArrayList<ArrayList<String>> returnValue = new ArrayList<>();
        ArrayList<ArrayList<String>> permutations = generatePerm(original);
        for (ArrayList<String> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                ArrayList<String> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }
}
