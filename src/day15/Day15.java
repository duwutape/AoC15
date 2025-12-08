package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day15 {
    public static void main(String[] args) {
        new Day15();
    }

    public Day15() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day15/input.txt");
        Scanner scanner = new Scanner(input);

        ArrayList<ArrayList<Integer>> ingredients = new ArrayList<>();
        ArrayList<Integer> ingredient1 = new ArrayList<>();
        ArrayList<Integer> ingredient2 = new ArrayList<>();
        ArrayList<Integer> ingredient3 = new ArrayList<>();
        ArrayList<Integer> ingredient4 = new ArrayList<>();
        ArrayList<Integer> ingredient5 = new ArrayList<>();

        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
        ingredients.add(ingredient4);
        ingredients.add(ingredient5);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].replaceAll(",", "");
            }

            ingredient1.add(Integer.parseInt(parts[2]));
            ingredient2.add(Integer.parseInt(parts[4]));
            ingredient3.add(Integer.parseInt(parts[6]));
            ingredient4.add(Integer.parseInt(parts[8]));
            ingredient5.add(Integer.parseInt(parts[10]));
        }

        ArrayList<int[]> combinations = new ArrayList<>();
        int[] combination = new int[4];
        generate(0, 100, combination, combinations);


        int maxProd = 0;
        int maxProdCal = 0;
        for (int[] combi : combinations) {
            ArrayList<ArrayList<Integer>> resIngs = new ArrayList<>();
            for (ArrayList<Integer> ingredient : ingredients) {
                ArrayList<Integer> resIng = new ArrayList<>();
                for (int i = 0; i < ingredient.size(); i++) {
                    resIng.add(ingredient.get(i) * combi[i]);
                }
                resIngs.add(resIng);
            }
            int prod = 1;
            for (int i = 0; i < resIngs.size() - 1; i++) {
                int sum = 0;
                for (Integer ing : resIngs.get(i)) {
                    sum += ing;
                }
                if (sum < 0) {
                    sum = 0;
                }
                prod *= sum;
            }
            int calories = 0;
            for (Integer cal : resIngs.getLast()) {
                calories += cal;
            }
            if (maxProd < prod) {
                maxProd = prod;
            }
            if (maxProdCal < prod && calories == 500) {
                maxProdCal = prod;
            }
        }

        System.out.println(maxProd);
        System.out.println(maxProdCal);
    }

    static void generate(int index, int remaining, int[] combo, ArrayList<int[]> results) {
        if (index == combo.length - 1) {
            combo[index] = remaining;
            results.add(combo.clone());
            return;
        }

        for (int i = 0; i <= remaining; i++) {
            combo[index] = i;
            generate(index + 1, remaining - i, combo, results);
        }
    }
}
