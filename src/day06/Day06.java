package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day06 {
    public static void main(String[] args) {
        new Day06();
    }

    public Day06() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File input = new File("src/day06/input.txt");
        Scanner scanner = new Scanner(input);

        ArrayList<String> operations = new ArrayList<>();
        while (scanner.hasNextLine()) {
            operations.add(scanner.nextLine());
        }

        int[][] lightsP1 = new int[1000][1000];
        int[][] lightsP2 = new int[1000][1000];

        System.out.println(runOperations(lightsP1, operations, true));
        System.out.println(runOperations(lightsP2, operations, false));
    }

    private int runOperations(int[][] lights, ArrayList<String> operations, boolean part1) {
        int countOn = 0;

        for (String operation : operations) {
            String[] split = operation.split(" ");
            if (split[0].equals("turn")) {
                String[] coords1Str = split[2].split(",");
                String[] coords2Str = split[4].split(",");
                int[] coords1 = new int[]{Integer.parseInt(coords1Str[0]), Integer.parseInt(coords1Str[1])};
                int[] coords2 = new int[]{Integer.parseInt(coords2Str[0]), Integer.parseInt(coords2Str[1])};

                countOn = turn(lights, split[1], coords1, coords2, countOn, part1);
            } else {
                String[] coords1Str = split[1].split(",");
                String[] coords2Str = split[3].split(",");
                int[] coords1 = new int[]{Integer.parseInt(coords1Str[0]), Integer.parseInt(coords1Str[1])};
                int[] coords2 = new int[]{Integer.parseInt(coords2Str[0]), Integer.parseInt(coords2Str[1])};

                countOn = toggle(lights, coords1, coords2, countOn, part1);
            }
        }
        return countOn;
    }

    private int turn(int[][] lights, String mode, int[] coords1, int[] coords2, int countOn, boolean part1) {
        if(part1){
            if (mode.equals("on")) {
                for (int y = coords1[0]; y <= coords2[0]; y++) {
                    for (int x = coords1[1]; x <= coords2[1]; x++) {
                        if(lights[y][x] == 0) {
                            countOn++;
                        }
                        lights[y][x] = 1;
                    }
                }
            } else {
                for (int y = coords1[0]; y <= coords2[0]; y++) {
                    for (int x = coords1[1]; x <= coords2[1]; x++) {
                        if (lights[y][x] == 1) {
                            countOn--;
                        }
                        lights[y][x] = 0;
                    }
                }
            }
        } else {
            if (mode.equals("on")) {
                for (int y = coords1[0]; y <= coords2[0]; y++) {
                    for (int x = coords1[1]; x <= coords2[1]; x++) {
                        lights[y][x] += 1;
                        countOn++;
                    }
                }
            } else {
                for (int y = coords1[0]; y <= coords2[0]; y++) {
                    for (int x = coords1[1]; x <= coords2[1]; x++) {
                        if (lights[y][x] > 0) {
                            lights[y][x] -= 1;
                            countOn--;
                        }
                    }
                }
            }
        }
        return countOn;
    }

    private int toggle(int[][] lights, int[] coords1, int[] coords2, int countOn, boolean part1) {
        if (part1){
            for (int y = coords1[0]; y <= coords2[0]; y++) {
                for (int x = coords1[1]; x <= coords2[1]; x++) {
                    if (lights[y][x] == 0) {
                        lights[y][x] = 1;
                        countOn++;
                    } else {
                        lights[y][x] = 0;
                        countOn--;
                    }
                }
            }
        } else {
            for (int y = coords1[0]; y <= coords2[0]; y++) {
                for (int x = coords1[1]; x <= coords2[1]; x++) {
                    lights[y][x] += 2;
                    countOn += 2;
                }
            }
        }
        return countOn;
    }
}
