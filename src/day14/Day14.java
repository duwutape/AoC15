package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day14 {
    public static void main(String[] args) {
        new Day14();
    }

    public Day14() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day14/input.txt");
        Scanner scanner = new Scanner(input);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<int[]> data = new ArrayList<>();
        ArrayList<Integer> distance = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            names.add(parts[0]);

            data.add(new int[]{Integer.parseInt(parts[3]), Integer.parseInt(parts[6]), Integer.parseInt(parts[13])});
        }

        System.out.println(getMaxDist(data));
        System.out.println(getMaxPoints(data));
    }

    private int getMaxDist(ArrayList<int[]> data) {
        int maxDist = 0;
        for (int[] singleData : data) {
            int countSec = 0;
            int dist = 0;
            int countFly = 0;
            int countRest = 0;
            boolean flying = true;

            while (countSec < 2503) {
                if (countFly == singleData[1]) {
                    countFly = 0;
                    flying = false;
                } else if (countRest == singleData[2]) {
                    countRest = 0;
                    flying = true;
                }

                if (flying) {
                    countFly++;
                    dist += singleData[0];
                } else {
                    countRest++;
                }
                countSec++;
            }

            if (maxDist == 0 || maxDist < dist) {
                maxDist = dist;
            }
        }
        return maxDist;
    }

    private int getMaxPoints(ArrayList<int[]> data) {
        ArrayList<Integer> points = new ArrayList<>();
        ArrayList<Integer> dist = new ArrayList<>();
        ArrayList<Integer> countFly = new ArrayList<>();
        ArrayList<Integer> countRest = new ArrayList<>();
        ArrayList<Boolean> flying = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            points.add(0);
            dist.add(0);
            countFly.add(0);
            countRest.add(0);
            flying.add(true);
        }

        for (int i = 0; i < 2503; i++) {
            for (int j = 0; j < data.size(); j++) {
                int[] singleData = data.get(j);
                if (countFly.get(j) == singleData[1]) {
                    countFly.set(j, 0);
                    flying.set(j, false);
                } else if (countRest.get(j) == singleData[2]) {
                    countRest.set(j, 0);
                    flying.set(j, true);
                }

                if (flying.get(j)) {
                    countFly.set(j, countFly.get(j) + 1);
                    dist.set(j, dist.get(j) + singleData[0]);
                } else {
                    countRest.set(j, countRest.get(j) + 1);
                }
            }
            int maxDist = 0;
            for (int singleDist : dist) {
                if (maxDist == 0 || maxDist < singleDist) {
                    maxDist = singleDist;
                }
            }
            for (int l = 0; l < dist.size(); l++) {
                if (dist.get(l) == maxDist) {
                    points.set(l, points.get(l) + 1);
                }
            }
        }
        int maxPoints = 0;
        for (int point : points) {
            if (maxPoints < point) {
                maxPoints = point;
            }
        }
        return maxPoints;
    }
}
