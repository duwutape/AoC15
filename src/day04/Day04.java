package day04;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Day04 {
    public static void main(String[] args) {
        new Day04();
    }

    public Day04() {
        try {
            solve();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private void solve() throws NoSuchAlgorithmException {
        String input = "iwrupvqb";

        MessageDigest md = MessageDigest.getInstance("MD5");
        int answer5 = -1;
        int answer6 = -1;

        for (int i = 0; i < 10000000; i++) {
            String key = input + i;

            byte[] bytes = key.getBytes();
            md.update(bytes);

            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String hashtext = bigInt.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            if (hashtext.matches("00000[a-z,0-9]*") && answer5 == -1) {
                answer5 = i;
            }
            if (hashtext.matches("000000[a-z,0-9]*") && answer6 == -1){
                answer6 = i;
            }
            if (answer5 != -1 && answer6 != -1){
                break;
            }
        }

        System.out.println(answer5);
        System.out.println(answer6);

    }
}
