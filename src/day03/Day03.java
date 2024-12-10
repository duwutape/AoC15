package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03 {
    public static void main(String[] args) {
        new Day03();
    }


    int[][] housesY1 = new int[10][10];
    int[][] housesY2 = new int[10][10];
    int x = 0;
    int y = 0;
    int xS = 0;
    int yS = 0;
    int xR = 0;
    int yR = 0;


    public Day03() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File file = new File("src/day03/input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<char[]> allDirs = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char[] dirs = line.toCharArray();
            allDirs.add(dirs);
        }

        housesY1[0][0] = 1;
        housesY2[0][0] = 2;


        boolean even = false;

        for (char[] dirs : allDirs) {
            for (char dir : dirs) {
                switch (dir) {
                    case '^' -> {
                        if (even) {
                            yS = inBounds(yS - 1, housesY2, "y2", even);
                        } else {
                            yR = inBounds(yR - 1, housesY2, "y2", even);
                        }
                        y = inBounds(y - 1, housesY1, "y1", even);
                    }
                    case '<' -> {
                        if (even) {
                            xS = inBounds(xS - 1, housesY2[yS], "y2", even);
                        } else {
                            xR = inBounds(xR - 1, housesY2[yR], "y2", even);
                        }
                        x = inBounds(x - 1, housesY1[y], "y1", even);
                    }
                    case '>' -> {
                        if (even) {
                            xS = inBounds(xS + 1, housesY2[yS], "y2", even);
                        } else {
                            xR = inBounds(xR + 1, housesY2[yR], "y2", even);
                        }
                        x = inBounds(x + 1, housesY1[y], "y1", even);
                    }
                    case 'v' -> {
                        if (even) {
                            yS = inBounds(yS + 1, housesY2, "y2", even);
                        } else {
                            yR = inBounds(yR + 1, housesY2, "y2", even);
                        }
                        y = inBounds(y + 1, housesY1, "y1", even);
                    }
                }
                if (even) {
                    housesY2[yS][xS]++;
                } else {
                    housesY2[yR][xR]++;
                }
                even = !even;
                housesY1[y][x]++;
            }
        }

        int countY1 = count(housesY1);
        int countY2 = count(housesY2);

        System.out.println(countY1);
        System.out.println(countY2);
    }

    private int inBounds(int i, int[][] data, String year, boolean even) {
        if (i < 0) {
            biggerArray("t", year);
            i++;
            if (year.equals("y2")) {
                if (even) {
                    yR++;
                } else {
                    yS++;
                }
            }
        } else if (i > data.length - 1) {
            biggerArray("b", year);
        }
        return i;
    }

    private int inBounds(int i, int[] data, String year, boolean even) {
        if (i < 0) {
            biggerArray("l", year);
            i++;
            if (year.equals("y2")) {
                if (even) {
                    xR++;
                } else {
                    xS++;
                }
            }
        } else if (i > data.length - 1) {
            biggerArray("r", year);
        }
        return i;
    }

    private void biggerArray(String side, String year) {
        int[][] newHouses = new int[1][1];
        int[][] houses;

        if (year.equals("y1")) {
            houses = housesY1;
        } else {
            houses = housesY2;
        }

        switch (side) {
            case "t" -> {
                newHouses = new int[houses.length + 1][houses[0].length];
                for (int y = 0; y < houses.length; y++) {
                    System.arraycopy(houses[y], 0, newHouses[y + 1], 0, houses[y].length);
                }
            }
            case "b" -> {
                newHouses = new int[houses.length + 1][houses[0].length];
                for (int y = 0; y < houses.length; y++) {
                    System.arraycopy(houses[y], 0, newHouses[y], 0, houses[y].length);
                }
            }
            case "l" -> {
                newHouses = new int[houses.length][houses[0].length + 1];
                for (int y = 0; y < houses.length; y++) {
                    System.arraycopy(houses[y], 0, newHouses[y], 1, houses[y].length);
                }
            }
            case "r" -> {
                newHouses = new int[houses.length][houses[0].length + 1];
                for (int y = 0; y < houses.length; y++) {
                    System.arraycopy(houses[y], 0, newHouses[y], 0, houses[y].length);
                }
            }
        }
        if (year.equals("y1")) {
            housesY1 = newHouses;
        } else {
            housesY2 = newHouses;
        }
    }

    private int count(int[][] houses) {
        int count = 0;
        for (int y = 0; y < houses.length; y++) {
            for (int x = 0; x < houses[y].length; x++) {
                if (houses[y][x] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
