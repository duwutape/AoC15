package day11;

import java.io.FileNotFoundException;

public class Day11 {
    public static void main(String[] args) {
        new Day11();
    }

    public Day11() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        //File input = new File("src/day11/input.txt");
        //Scanner scanner = new Scanner(input);

        String input = "hepxcrrq";
        int count = 0;
        while (count < 2) {
            int[] ascii = input.chars().toArray();
            input = incrementPW(ascii, ascii.length - 1);
            if (checkValid(input)) {
                System.out.println(input);
                count++;
            }
        }

    }

    private String incrementPW(int[] pw, int index) {

        boolean overflow = false;
        if (pw[index] >= 122) {
            pw[index] = 97;
            if (index - 1 >= 0) {
                incrementPW(pw, index - 1);
            }
        } else {
            pw[index]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : pw) {
            sb.append((char) i);
        }

        return sb.toString();
    }

    private boolean checkValid(String pw) {
        if (!checkThreeInc(pw)) {
            return false;
        }
        if (!checkNoIOL(pw)) {
            return false;
        }
        if (!checkPair(pw)) {
            return false;
        }
        return true;
    }

    private boolean checkThreeInc(String pw) {
        int[] ascii = pw.chars().toArray();
        for (int i = 0; i < ascii.length - 2; i++) {
            int current = ascii[i];
            if (ascii[i + 1] == current + 1 && ascii[i + 2] == current + 2) {
                return true;
            }
        }
        return false;
    }

    private boolean checkNoIOL(String pw) {
        return !pw.contains("i") && !pw.contains("o") && !pw.contains("l");
    }

    private boolean checkPair(String pw) {
        int[] ascii = pw.chars().toArray();
        int count = 0;
        for (int i = 0; i < ascii.length - 1; i++) {
            int current = ascii[i];
            if (ascii[i + 1] == current) {
                count++;
                i++;
            }
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }
}
