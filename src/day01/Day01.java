package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01 {
    public Day01() {
        try {
            solve();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws FileNotFoundException {
        File file = new File("src/day01/input.txt");
        Scanner scanner = new Scanner(file);

        int floor = 0;
        int pos = 0;
        boolean count = true;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            for (int i = 0; i < line.length(); i++) {
                if(count){
                    pos++;
                }
                if (line.charAt(i) == '(') {
                    floor += 1;
                } else {
                    floor -= 1;
                }
                if(count && floor == -1){
                    count = false;
                }
            }

        }
        System.out.println(floor);
        System.out.println(pos);
    }
}
